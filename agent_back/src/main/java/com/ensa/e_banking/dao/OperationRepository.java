package com.ensa.e_banking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensa.e_banking.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	
//	@Query(value ="SELECT * FROM operation  where  id_client like ?1",nativeQuery=true)
//	List <Operation>findOperation(@Param("x") Long id);
	@Query(value ="SELECT * FROM operation  where  id_source=:x or id_destination=:x",nativeQuery=true)
	List <Operation>findOperationByIdClient(@Param("x") Long id);
	 
}
