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
	@Query("select c from Compte c  where c.rib like :x  and c.etat =1")	
	 public List<Compte> chercherA(@Param("x") String mc);
	
	@Query("select c from Compte c  where c.rib like :x  and c.etat =0")	
	 public List<Compte> chercherD(@Param("x") String mc);
	
	//@Query("SELECT num_compte FROM Compte ORDER BY id DESC LIMIT 1")
	@Query(value ="SELECT num_compte FROM Compte ORDER BY num_compte DESC LIMIT 1",nativeQuery=true)
	public Long dernierEnregistrement();
	
	@Query(value ="SELECT * FROM compte where etat =1",nativeQuery=true)
	List <Compte> findCompteActive();
	
	@Query(value ="SELECT * FROM compte where etat =0",nativeQuery=true)
	List <Compte> findCompteDesactive();

	

	

}
