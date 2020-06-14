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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getPrincipal().equals("anonymousUser")) {
            Client client = clientRepository.findByUsername(auth.getName());
            return client;
        }
        return null;

    }




    @RequestMapping("/client/list")
    public List<Client> getClients()
    {
        return clientRepository.findAll();
    }

    @RequestMapping(value="/client/ajoutClient",method= RequestMethod.POST)
    public Client saveClient(@RequestBody Client client) {
        List<Client> listClient=clientRepository.findAll();
        for(Client cl:listClient) {
            if (client.getCin().equals(cl.getCin())){
                return cl;
            }
        }

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

}
