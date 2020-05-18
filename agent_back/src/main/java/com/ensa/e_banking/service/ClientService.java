package com.ensa.e_banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	/*@RequestMapping(value="/client/listClient",method=RequestMethod.GET)
	public Page<Client> listeClient(@RequestParam(name="page",defaultValue="0")int page) {
		System.out.println("list");
		return clientMetier.getClients(page);
	}*/
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
	
	/*@RequestMapping(value="/client/chercher",method=RequestMethod.GET)
	public Page<Client> chercher(@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size
			){
		return clientMetier.chercher(mc, page,size);
	}*/
	
	@RequestMapping(value="/client/chercher/{mc}",method=RequestMethod.GET)
	public List<Client> chercher(@PathVariable String mc){
		System.out.println("cherche");
		return clientMetier.chercher(mc);}
	
	
			
}
