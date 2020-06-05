package com.ensa.e_banking.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensa.e_banking.entities.Client;

//
//public interface ClientRepository extends JpaRepository<Client,Long>{
// Client findByEmail(String email);
//
// @Query("select c from Client c  where c.nom like :x or c.prenom like :x ")
//public List<Client> chercher(@Param("x") String mc);
//
//}
