package com.ensa.e_banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ensa.e_banking.dao.OperationRepository;
import com.ensa.e_banking.entities.Agent;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.entities.Operation;
import com.ensa.e_banking.interfacesMetier.OperationMetier;

@RestController
@CrossOrigin("*")
public class OperationService {
	@Autowired
	OperationMetier operationMetier;
	
	
	
	@RequestMapping(value="/operation/versement",method=RequestMethod.POST)
	public boolean verser(@RequestBody Operation operation) {
		return operationMetier.verser(operation);
	}
	
	@RequestMapping(value="/operation/retrait",method=RequestMethod.POST)
	public boolean retirer(@RequestBody Operation operation) {
		return operationMetier.retirer(operation);
	}
	
	@RequestMapping(value="/operation/virement",method=RequestMethod.POST)
	 public boolean virement(@RequestBody Operation operation) {
		return operationMetier.virement(operation);
		
	}
	
	@RequestMapping(value="/operation/recharge/{codeRecharge}",method=RequestMethod.POST)
	 public boolean recharge(@RequestBody Operation operation, @PathVariable Long codeRecharge) {
		return operationMetier.recharge(operation, codeRecharge);
	}
	
	@RequestMapping(value="/operation/listOperation/{id}",method=RequestMethod.GET)
	public List<Operation> getOperationsByClient(@PathVariable Long id){
		
		return operationMetier.getOperationById(id);
	}
	@RequestMapping(value="/operation/list",method=RequestMethod.GET)
	public List<Operation> getList(){
	return  operationMetier.getOperations();
	}
	


}
