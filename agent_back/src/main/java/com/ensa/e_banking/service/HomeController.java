package com.ensa.e_banking.service;


import com.ensa.e_banking.interfacesMetier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.ensa.e_banking.entities.Agent;
import com.ensa.e_banking.interfacesMetier.AgentMetier;

@RestController
@CrossOrigin("*")
public class HomeController{

	@Autowired
	AgentMetier agentMetier;

	@Autowired
	ClientMetier clientMetier;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/agent/currentAgent")
	public Agent currentAgent() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth);
	    if(!auth.getPrincipal().equals("anonymousUser")) {
	    	Agent agent = agentMetier.getAgentByUsername(auth.getName());
	         return agent;
	    }
	    return null;
	}



}
	
	


