package com.ensa.e_banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.e_banking.dao.ClientRepository;
import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.interfacesMetier.ClientMetier;


@RestController
@CrossOrigin("*")
public class ClientService {
	@Autowired
	private ClientMetier clientMetier;
	
	@RequestMapping(value="/client/ajoutClient",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		client.setPassord(clientMetier.genererPassword());
		return clientMetier.saveClient(client);
	}
	
	@RequestMapping(value="/client/listClient",method=RequestMethod.GET)
	public List<Client> listeClient() {
		return clientMetier.getClients();
	}
	
	@RequestMapping(value="/client/update/{id}",method=RequestMethod.PUT)
	public Client update(@PathVariable long id,@RequestBody Client client){
		client.setId(id);
	    client.setPassord(clientMetier.getClientById(id).getPassord());
		return clientMetier.upDateClient(id, client);
	}
	
	@RequestMapping(value="/client/{id}",method=RequestMethod.GET)
	public Client getContact(@PathVariable Long id){
		return clientMetier.getClientById(id);
	}
	

	@RequestMapping(value="/client/delete/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable long id){
	  
		return clientMetier.deleteClient(id);
	}

}
