package com.ensa.e_banking.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

import com.ensa.e_banking.dao.CompteRepository;
import com.ensa.e_banking.dao.OperationRepository;

import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.entities.Operation;
import com.ensa.e_banking.security.SecurityConstants;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.e_banking.config.SmtpMailSender;
import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.interfacesMetier.ClientMetier;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin("*")
public class ClientService {



    @Autowired
    RestTemplate restTemplate;

    private String url = "http://localhost:8082";
	private String urla="http://localhost:8083";

	HttpHeaders headers=new HttpHeaders();

//	@Autowired
//	private ClientMetier clientMetier;
//
	@Autowired
	private SmtpMailSender smtpMailSender;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Autowired
	private  HomeController homeController;


//
	@RequestMapping(value="/client/ajoutClient",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client client,HttpServletRequest request) {


		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Client> req = new HttpEntity<>(client,headers);
		return restTemplate.postForObject(url+"/client/ajoutClient", req, Client.class);
	}
//
//	/*@RequestMapping(value="/client/listClient",method=RequestMethod.GET)
//	public Page<Client> listeClient(@RequestParam(name="page",defaultValue="0")int page) {
//		System.out.println("list");
//		return clientMetier.getClients(page);
//	}*/
//
@Autowired
BCryptPasswordEncoder bCryptPasswordEncoder=new  BCryptPasswordEncoder();
	@RequestMapping("/agent/send-email")
	public void sendMail(@RequestBody Client client) throws MessagingException {
		System.out.println(client.getPassword());
	System.out.println(client.getUsername().toString());

	String body="Votre mot de passe est "+client.getPassword()+" Bienvenue chez nous";
	this.smtpMailSender.sendMail(client.getUsername(), "Your Password", body);

	}
//
//	@RequestMapping(value="/agent/listClient",method=RequestMethod.GET)
//	public List<Client> listeClient() {
//		System.out.println("list");
//		return clientMetier.getClients();
//	}
//
//
	@RequestMapping(value="/client/update/{id}",method=RequestMethod.PUT)
	public Boolean updateClient(@PathVariable long id,@RequestBody Client client,HttpServletRequest request){

		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Client> entity = new HttpEntity<Client>(client,headers);

		restTemplate.put(url+"client/update/"+id, entity);
		return true;
	}
//
	@RequestMapping(value="/client/{id}",method=RequestMethod.GET)
	public Client getClientById(@PathVariable Long id,HttpServletRequest request) throws ParseException {




//		return restTemplate.getForObject(url+"/client/"+id, Client.class);
		List<Client> list = getClients(request);
		for(Client cl : list){

			if(cl.getId() == id) {
				return cl;
			}
		}
		return null;
	}


	@Transactional
	@RequestMapping(value="/client/delete/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id,HttpServletRequest request){

		Compte compte=compteRepository.findCompteByIdClient(id);

     if(operationRepository.findOperationByIdCompte(compte.getRib()) !=null){
		operationRepository.deleteOperationByCompte(compte.getRib());
		 compteRepository.deleteCompteByIdClient(id);
     System.out.println("opera not null");}
     else{  compteRepository.deleteCompteByIdClient(id);}



		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Client> entity = new HttpEntity<Client>(headers);


	  // restTemplate.delete(url+"client/delete/"+id,entity);
		restTemplate.exchange(url+"client/delete/"+id, HttpMethod.DELETE,entity, Boolean.class);
		String act= "l'agent ID : "+ homeController.currentAgent().getId() + " a supprimé le client ID : "+ id +
				" ainsi que son compte RIB : " + compte.getRib();

		restTemplate.postForObject(urla + "/supprimerClient", act, String.class);
	    return true;
	}
//
//	/*@RequestMapping(value="/client/chercher",method=RequestMethod.GET)
//	public Page<Client> chercher(@RequestParam(name="mc",defaultValue="") String mc,
//			@RequestParam(name="page",defaultValue="0") int page,
//			@RequestParam(name="size",defaultValue="5") int size
//			){
//		return clientMetier.chercher(mc, page,size);
//	}
//	/*
//
	@RequestMapping(value="/agent/chercher/{mc}",method=RequestMethod.GET)
	public List<Client> chercher(@PathVariable String mc,HttpServletRequest request){
		System.out.println(mc);
		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Client> entity = new HttpEntity<Client>(headers);
			ResponseEntity<List<Client>> response = restTemplate.exchange(
					url+"/client/recherche/"+mc, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Client>>() {}
			);

			List<Client> list = response.getBody();
			return  list;
		}


    @RequestMapping(value="/client/list",method = RequestMethod.GET)
    public List<Client> getClients(HttpServletRequest request){


		headers.set(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX+request.getHeader(SecurityConstants.HEADER_STRING));
		HttpEntity<Client> entity = new HttpEntity<Client>(headers);
		ResponseEntity<List<Client>> response = restTemplate.exchange(
				url+"/client/list", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Client>>() {}
		);
		List<Client> list = response.getBody();
		return list;

		/*
        ResponseEntity<List<Client>> response = restTemplate.exchange(
                url+"/client/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {}
        );
        List<Client> list = response.getBody();
        return  list;*/
    }
			
}
