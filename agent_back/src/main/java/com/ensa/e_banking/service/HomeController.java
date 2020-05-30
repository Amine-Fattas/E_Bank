package com.ensa.e_banking.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ensa.e_banking.entities.Agent;
import com.ensa.e_banking.interfacesMetier.AgentMetier;

@RestController
@CrossOrigin("*")
public class HomeController {

	@Autowired
	AgentMetier agentMetier;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/home/currentAgent")
	public Agent currentAgent() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	    if(!auth.getPrincipal().equals("anonymousUser")) {
	    	System.out.println(auth.getPrincipal());
	    	Agent agent = agentMetier.getAgentByUsername(auth.getName());
	         return agent;
	    }
	    return null;
	}

	

}
	
	
	

