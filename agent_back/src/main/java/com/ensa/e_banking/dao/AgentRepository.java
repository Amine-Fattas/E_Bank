package com.ensa.e_banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.e_banking.entities.Agent;

public interface AgentRepository extends JpaRepository<Agent,Long> {
	
	Agent findByUsername(String username);
	Agent findByPassword(String password);

}
