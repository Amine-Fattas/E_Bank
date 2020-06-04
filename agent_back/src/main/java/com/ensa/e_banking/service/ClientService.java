package com.ensa.e_banking.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.e_banking.config.SmtpMailSender;
import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.interfacesMetier.ClientMetier;




@RestController
@CrossOrigin("*")
public class ClientService {
	@Autowired
	private ClientMetier clientMetier;
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	@RequestMapping(value="/agent/ajoutClient",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		System.out.println("ajoutC-1");
		client.setPassword(clientMetier.genererPassword());
		System.out.println(client.getPassword());
		return clientMetier.saveClient(client);
	}
	
	/*@RequestMapping(value="/client/listClient",method=RequestMethod.GET)
	public Page<Client> listeClient(@RequestParam(name="page",defaultValue="0")int page) {
		System.out.println("list");
		return clientMetier.getClients(page);
	}*/
	
	@RequestMapping("/agent/send-email")
	public void sendMail(@RequestBody Client client) throws MessagingException {
		System.out.println("email");
		System.out.println(client);
		String body="Votre mot de passe est "+client.getPassword()+" Bienvenue chez nous";
		this.smtpMailSender.sendMail("nouamanemakhloufi6@gmail.com", "Your Password", body);
		
	}
	
	@RequestMapping(value="/agent/listClient",method=RequestMethod.GET)
	public List<Client> listeClient() {
		System.out.println("list");
		return clientMetier.getClients();
	}

	
	@RequestMapping(value="/agent/update/{id}",method=RequestMethod.PUT)
	public Client update(@PathVariable long id,@RequestBody Client client){
		System.out.println("edit");
		client.setId(id);
	    client.setPassword(clientMetier.getClientById(id).getPassword());
		return clientMetier.upDateClient(id, client);
	}
	
	@RequestMapping(value="/agent/{id}",method=RequestMethod.GET)
	public Client getContact(@PathVariable Long id){
		return clientMetier.getClientById(id);
	}
	

	@RequestMapping(value="/agent/delete/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id){
	  
		return clientMetier.deleteClient(id);
	}
	
	/*@RequestMapping(value="/client/chercher",method=RequestMethod.GET)
	public Page<Client> chercher(@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size
			){
		return clientMetier.chercher(mc, page,size);
	}*/
	
	@RequestMapping(value="/agent/chercher/{mc}",method=RequestMethod.GET)
	public List<Client> chercher(@PathVariable String mc){
		System.out.println("cherche");
		return clientMetier.chercher(mc);}
	
	
			
}
