package com.ensa.e_banking.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.entities.Operation;

public interface CompteRepository extends JpaRepository<Compte,Long> {
	@Query("select c from Compte c  where c.etat like :x ")	
	 public Page<Compte> chercher(@Param("x") String mc,Pageable page);
	
	//@Query("SELECT num_compte FROM Compte ORDER BY id DESC LIMIT 1")
	@Query(value ="SELECT num_compte FROM Compte ORDER BY num_compte DESC LIMIT 1",nativeQuery=true)
	public Long dernierEnregistrement();
	
	@Query(value ="SELECT * FROM compte where etat =1",nativeQuery=true)
	List <Compte> findCompteActive();
	
	@Query(value ="SELECT * FROM compte where id_client=:x",nativeQuery=true)
	Compte findCompteByIdClient(@Param("x") Long id_client);

	

}
