package com.ensa.e_banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.e_banking.entities.Agent;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent,Long> {
	
	Agent findByUsername(String username);
	Optional<Agent> findById(Long id);
	Agent findByPassword(String password);
	@Query(value="SELECT id from agent order by num_contrat desc LIMIT 1",nativeQuery=true)
	public Long last_suffix();

}
