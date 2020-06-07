package com.ensa.controller;

import com.ensa.dao.ClientRepository;
import com.ensa.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class HomeController {

    @Autowired
    ClientRepository clientRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/client/currentClient")
    public Client currentClient() {
        System.out.println("agent");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getPrincipal().equals("anonymousUser")) {

            System.out.println(auth.getPrincipal());
            Client client = clientRepository.findByUsername(auth.getName());
            return client;
        }
        return null;

    }




    @RequestMapping("/client/list")
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    @RequestMapping(value="/client/ajoutClient",method= RequestMethod.POST)
    public Client saveClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @RequestMapping(value="/client/delete/{id}",method= RequestMethod.DELETE)
	public boolean deleteClient(@PathVariable Long id) {
		clientRepository.deleteById(id);
		return true;
	}

	@RequestMapping(value="/client/{id}",method= RequestMethod.GET)
    public Optional<Client> getClientById(@PathVariable Long id){
        return  clientRepository.findById(id);
    }

    @RequestMapping(value="/client/update/{id}",method= RequestMethod.PUT)
    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        System.out.println("edit");
        Client cl = clientRepository.findById(id).get();
        if(cl==null) throw new RuntimeException("Client not Found");
        client.setId(cl.getId());
	    client.setPassword(cl.getPassword());
		return clientRepository.save(client);
    }

    @RequestMapping(value="/client/recherche/{mc}",method= RequestMethod.GET)
    public List<Client> getClientByMc(@PathVariable String mc){
        System.out.println(mc);
        return clientRepository.chercher("%"+mc+"%");

    }


    //	@RequestMapping(value="/agent/update/{id}",method=RequestMethod.PUT)
//	public Client update(@PathVariable long id,@RequestBody Client client){
//		System.out.println("edit");
//		client.setId(id);
//	    client.setPassword(clientMetier.getClientById(id).getPassword());
//		return clientMetier.upDateClient(id, client);
//	}


}
