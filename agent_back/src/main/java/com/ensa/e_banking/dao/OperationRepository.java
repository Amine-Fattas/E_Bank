package com.ensa.e_banking.dao;

import java.util.List;

import com.ensa.e_banking.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensa.e_banking.entities.Operation;
import org.springframework.security.core.parameters.P;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	
//	@Query(value ="SELECT * FROM operation  where  id_client like ?1",nativeQuery=true)
//	List <Operation>findOperation(@Param("x") Long id);
	@Query(value ="SELECT * FROM operation  where  rib_source=:x or rib_destination=:x",nativeQuery=true)
	List <Operation> findOperationByIdCompte(@Param("x") String rib);

	//@Query("select c from Compte c  where c.rib like :x  and c. =:y")
	@Query("select o from Operation o  where o.compteSource.rib like :x or o.typeOperation like :x or  o.compteDestination.rib like :x and o.compteDestination.rib like :y or o.compteSource.rib like :y")
    public List<Operation> chercherO(@Param("x") String mc,@Param("y") String rib);

	@Query("select o from Operation o  where o.compteSource.rib like :x or o.typeOperation like :x or  o.compteDestination.rib like :x ")
	public List<Operation> chercherOperation(@Param("x") String mc);

	@Modifying
	@Query(value ="delete FROM operation where  rib_source=:x or rib_destination=:x",nativeQuery=true)
	int deleteOperationByCompte(@Param("x") String rib);





}
