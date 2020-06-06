package com.ensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entities.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
	Client findByUsername(String email);
	Optional<Client> findById(Long id);


}
