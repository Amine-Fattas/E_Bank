package com.ensa.e_banking.service;



import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.interfacesMetier.ClientMetier;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
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
		System.out.println("agent");
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	    if(!auth.getPrincipal().equals("anonymousUser")) {
	    	System.out.println(auth.getPrincipal());
	    	Agent agent = agentMetier.getAgentByUsername(auth.getName());
	         return agent;
	    }
	    return null;
	}





	

}
	
	
	

