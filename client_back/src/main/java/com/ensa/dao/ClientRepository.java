package com.ensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
	Client findByUsername(String email);

}
