package com.ensa.e_banking.service;

import java.util.List;

import javax.mail.MessagingException;

import com.ensa.e_banking.dao.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

//	@Autowired
//	private ClientMetier clientMetier;
//
	@Autowired
	private SmtpMailSender smtpMailSender;

	@Autowired
	private CompteRepository compteRepository;
//
	@RequestMapping(value="/client/ajoutClient",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		return restTemplate.postForObject(url+"/client/ajoutClient", client, Client.class);
	}
//
//	/*@RequestMapping(value="/client/listClient",method=RequestMethod.GET)
//	public Page<Client> listeClient(@RequestParam(name="page",defaultValue="0")int page) {
//		System.out.println("list");
//		return clientMetier.getClients(page);
//	}*/
//
//	@RequestMapping("/agent/send-email")
//	public void sendMail(@RequestBody Client client) throws MessagingException {
//		System.out.println("email");
//		System.out.println(client);
//		String body="Votre mot de passe est "+client.getPassword()+" Bienvenue chez nous";
//		this.smtpMailSender.sendMail(client.getUsername(), "Your Password", body);
//	}
//
//	@RequestMapping(value="/agent/listClient",method=RequestMethod.GET)
//	public List<Client> listeClient() {
//		System.out.println("list");
//		return clientMetier.getClients();
//	}
//
//
	@RequestMapping(value="/client/update/{id}",method=RequestMethod.PUT)
	public Boolean updateClient(@PathVariable long id,@RequestBody Client client){
		restTemplate.put(url+"client/update/"+id, client);
		return true;
	}
//
	/*@RequestMapping(value="/client/{id}",method=RequestMethod.GET)
	public Client getClientById(@PathVariable Long id){
		return restTemplate.getForObject(url+"/client/"+id, Client.class);
	}


	@Transactional
	@RequestMapping(value="/client/delete/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id){
		compteRepository.deleteCompteByIdClient(id);
	    restTemplate.delete(url+"client/delete/"+id);
	    return true;
	}
//
//	/*@RequestMapping(value="/client/chercher",method=RequestMethod.GET)
//	public Page<Client> chercher(@RequestParam(name="mc",defaultValue="") String mc,
//			@RequestParam(name="page",defaultValue="0") int page,
//			@RequestParam(name="size",defaultValue="5") int size
//			){
//		return clientMetier.chercher(mc, page,size);
//	}*/
//
//	@RequestMapping(value="/agent/chercher/{mc}",method=RequestMethod.GET)
//	public List<Client> chercher(@PathVariable String mc){
//		System.out.println("cherche");
//		return clientMetier.chercher(mc);}

    @RequestMapping(value="/client/list",method = RequestMethod.GET)
    public List<Client> getClients(){
        ResponseEntity<List<Client>> response = restTemplate.exchange(
                url+"/client/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {}
        );
        List<Client> list = response.getBody();
        return  list;
    }
			
}
