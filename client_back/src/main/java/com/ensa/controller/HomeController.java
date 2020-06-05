package com.ensa.controller;

import com.ensa.dao.ClientRepository;
import com.ensa.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {

    @Autowired
    ClientRepository clientRepository;


    @RequestMapping("/client/currentClient")
    public Client currentClient() {
        System.out.println("agent");
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if(!auth.getPrincipal().equals("anonymousUser")) {
            System.out.println(auth.getPrincipal());
            Client client = clientRepository.findByUsername(auth.getName());
            return client;
        }
        return null;
    }
}
