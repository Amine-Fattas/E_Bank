package com.ensa.e_banking.service;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.e_banking.entities.Agent;
import com.ensa.e_banking.interfacesMetier.AgentMetier;

@RestController
@CrossOrigin("*")
public class HomeController {

	@Autowired
	AgentMetier agentMetier;
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/acceuil")
	public Agent acceuil(Principal principal) { 
		
		String username=principal.getName();
        Agent agent = agentMetier.getAgentByUsername(username);
		return agent;
		}
	/*public String getAgent(Principal user) {
		System.out.println("api");
     System.out.println(user.getName());
		//return agentMetier.getAgentByUsername(user.getName());*/
    
	
	/*@RequestMapping(value="/logout", method = RequestMethod.GET)
	public Boolean logoutPage (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logout");
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	        return true;
	    }
	    return false;//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}*/
	
	}
	
	

