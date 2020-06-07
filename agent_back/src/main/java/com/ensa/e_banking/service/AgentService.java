package com.ensa.e_banking.service;

import com.ensa.e_banking.dao.AgentRepository;
import com.ensa.e_banking.entities.Agence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.ensa.e_banking.entities.Agent;
import com.ensa.e_banking.interfacesImpl.AgentMetierImp;

import java.util.List;
import java.util.Optional;

@RestController
public class AgentService {
	@Autowired
	AgentMetierImp agentMetier;
	@Autowired
	AgentRepository agentRepository;
	
	@RequestMapping(value="/infoAgent/{id}",method=RequestMethod.GET)
	public Agent getAgent(@PathVariable Long id) {
		return agentMetier.getAgent(id);
	}

	@RequestMapping(value="/agent/list",method =RequestMethod.GET)
	public List<Agent> getAgents(){
		return this.agentRepository.findAll();
	}
	@RequestMapping(value = "/agent/add",method =RequestMethod.POST)
	public Agent save(@RequestBody Agent agent){
		Long lastSuffix;
		if(agentRepository.last_suffix() == null){
			lastSuffix=10000000L;
		}
		else{lastSuffix=agentRepository.last_suffix()+1;}
		agent.setId(lastSuffix);
		agent.setNumContrat("AFOIH-"+Long.toString(agent.getId()));
		agent.setUsername(Long.toString(agent.getId())+"@AFOIHebank.com");
		return  agentRepository.save(agent);

	}
	@RequestMapping(value="/agent/update/{id}",method= RequestMethod.PUT)
	public Agent updateAgent(@PathVariable Long id, @RequestBody Agent agent){
		System.out.println("edit");
		Agent ag = agentRepository.findById(id).get();
        if(id==ag.getId())
            ag.setId(id);
        agent.setNumContrat("AFOIH-"+Long.toString(agent.getId()));
       // Agence agence=agenceRepository.findByNomAgence(agent.getAgence().getNomAgence());
        //agent.setAgence(agence);
       return agentRepository.save(agent);

	}
	@RequestMapping(value="/agent/{id}",method=RequestMethod.GET)
	public Optional<Agent> getAgentById(@PathVariable Long id){
		return  agentRepository.findById(id);
	}



}
