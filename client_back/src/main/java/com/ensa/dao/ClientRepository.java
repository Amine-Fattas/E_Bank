package com.ensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.entities.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
	Client findByUsername(String email);
	Optional<Client> findById(Long id);
	@Query("select c from Client c  where c.nom like :x or c.prenom like :x ")
    public List<Client> chercher(@Param("x") String mc);


}
