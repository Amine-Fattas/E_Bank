package com.ensa.e_banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ensa.e_banking.entities.Agent;
import com.ensa.e_banking.interfacesImpl.AgentMetierImp;

@RestController
public class AgentService {
	@Autowired
	AgentMetierImp agentMetier;
	
	@RequestMapping(value="/infoAgent/{id}",method=RequestMethod.GET)
	public Agent getAgent(@PathVariable Long id) {
		return agentMetier.getAgent(id);
	}

}
