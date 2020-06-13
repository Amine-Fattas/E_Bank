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

	@RequestMapping(value = "/infoAgent/{id}", method = RequestMethod.GET)
	public Agent getAgent(@PathVariable Long id) {
		return agentMetier.getAgent(id);
	}

	@RequestMapping(value = "/agent/list", method = RequestMethod.GET)
	public List<Agent> getAgents() {

		return agentRepository.findAll();
	}

	@RequestMapping(value = "/agent/list/{keyword}", method = RequestMethod.GET)
	public List<Agent> getAgentsk(@PathVariable String keyword) {

			return agentRepository.findByKeyword(keyword);

	}


	@RequestMapping(value = "/agent/agentsbyagence/{id}", method = RequestMethod.GET)
	public List<Agent> getAgentsByAgence(@PathVariable Integer id) {
		System.out.println(id);
		return agentRepository.findAllByNumAgence(id);
	}


	@RequestMapping(value = "/agent/add", method = RequestMethod.POST)
	public Agent save(@RequestBody Agent agent) {
		Long lastSuffix;
		if (agentRepository.last_suffix() == null) {
			lastSuffix = 10000000L;
		} else {
			lastSuffix = agentRepository.last_suffix() + 1;
		}
		agent.setId(lastSuffix);
		agent.setNumContrat("AFOIH-" + Long.toString(agent.getId()));
		agent.setUsername(Long.toString(agent.getId()) + "@AFOIHebank.com");
		return agentRepository.save(agent);

	}

	@RequestMapping(value = "/agent/update/{id}", method = RequestMethod.POST)
	public Agent updateAgent(@PathVariable Long id, @RequestBody Agent agent) {
		System.out.println("agent" + id);
		System.out.println("agent" + agent.getId());
		System.out.println("agent" + agent.getNom());
		System.out.println("agent" + agent.getPassword());
		System.out.println("agent" + agent.getUsername());
		System.out.println("agent" + agent.getNumContrat());
		System.out.println("agent" + agent.getNumAgence());
		//Agent ag = agentRepository.findById(id).get();
		//if(id.equals(ag.getId()))
		//   agent.setId(id);
		agent.setNumContrat("AFOIH-" + Long.toString(agent.getId()));
		agent.setUsername(Long.toString(agent.getId()) + "@AFOIHebank.com");

		// Agence agence=agenceRepository.findByNomAgence(agent.getAgence().getNomAgence());
		//agent.setAgence(agence);
		return agentRepository.save(agent);

	}

	@RequestMapping(value = "/agent/{id}", method = RequestMethod.GET)
	public Optional<Agent> getAgentById(@PathVariable Long id) {
		return agentRepository.findById(id);
	}


	@RequestMapping(value = "/agent/deleteagent/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable Long id) {

		Agent a = agentRepository.findById(id).get();
		agentRepository.delete(a);

	}

	@RequestMapping(value = "/agent/deleteagence/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable Integer id) {
		List<Agent> agents= agentRepository.findAllByNumAgence(id);
		for (int i = 0; i < agents.size(); i++) {
			agents.get(i).setNumAgence(0);
			agentRepository.save(agents.get(i));
		}

	}


}
