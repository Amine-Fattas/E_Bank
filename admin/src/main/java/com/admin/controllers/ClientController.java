package com.admin.controllers;

import com.admin.Repository.AgentRepository;
import com.admin.Repository.ClientRepository;
import com.admin.models.Agent;
import com.admin.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ClientController {

        @Autowired
        private ClientRepository clientRepository;
        @Autowired
        private AgentRepository agentRepository;

        @RequestMapping(value="/clients")
        public String list(Model model) {
            List<Client> clients = clientRepository.findAll();
           // Agent agent = agentRepository.findById(id);
            model.addAttribute("listeClients",clients);
           // model.addAttribute("agent",agent);
            return "Client/clients";
        }
    @RequestMapping(value="/add-client" , method= RequestMethod.GET)
    public String add(Model model, Client client){
        model.addAttribute("client",new Client());
        return "Client/add-client";
    }
    @RequestMapping(path = "/edit-client", method = RequestMethod.GET)
    public String editClient(Model model,int id) {
        Client c=  clientRepository.findById(id).get();
        model.addAttribute("client",c);
        return "Client/edit-client";
    }

    @RequestMapping(value="/save-client" , method= RequestMethod.POST)
    public String save(Model model, Client client){
        clientRepository.save(client);
        return "redirect:/clients";
    }
    @RequestMapping(value="/delete-client" , method= RequestMethod.GET)
    public String delete(Model model, Client client){
        clientRepository.delete(client);
        return "redirect:/clients";

    }

}

