package com.ensa.e_banking.service;



import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.interfacesMetier.ClientMetier;
import com.ensa.e_banking.security.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.web.bind.annotation.*;

import com.ensa.e_banking.entities.Agent;
import com.ensa.e_banking.interfacesMetier.AgentMetier;

import java.security.Principal;
import java.util.Date;

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
		System.out.println(auth);
	    if(!auth.getPrincipal().equals("anonymousUser")) {
	    	System.out.println("je suis la");
	    	Agent agent = agentMetier.getAgentByUsername(auth.getName());
	         return agent;
	    }
	    return null;
	}

	String genererToken(){
		//request.getHeader(SecurityConstants.HEADER_STRING)
		String jwtToken= Jwts.builder()
				.setSubject(currentAgent().getUsername())
				.setExpiration(new
						Date(System.currentTimeMillis()+ SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
				.claim("agent", "agentBank")
				.compact();
		return "Authorization :"+SecurityConstants.TOKEN_PREFIX+jwtToken;
	}





	

}
	
	


