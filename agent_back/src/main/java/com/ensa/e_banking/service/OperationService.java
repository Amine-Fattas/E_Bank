package com.ensa.e_banking.service;

import java.util.List;

import com.ensa.e_banking.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ensa.e_banking.entities.Operation;
import com.ensa.e_banking.interfacesMetier.OperationMetier;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;

@RestController
@CrossOrigin("*")
public class OperationService {
	@Autowired
	OperationMetier operationMetier;

	@Autowired
	test test;
	
	@RequestMapping(value="/operation/versement",method=RequestMethod.POST)
	public boolean verser(@RequestBody Operation operation) {
		return operationMetier.verser(operation);
	}
	
	@RequestMapping(value="/operation/retrait",method=RequestMethod.POST)
	public boolean retirer(@RequestBody Operation operation) {
		return operationMetier.retirer(operation);
	}
	
	@RequestMapping(value="/operation/virement",method=RequestMethod.POST)
	 public boolean virement(@RequestBody Operation operation, HttpServletRequest req) {

		//if(!test.check(req)) throw new HTTPException(403);
		return operationMetier.virement(operation);
	}
	
	@RequestMapping(value="/operation/recharge/{codeRecharge}",method=RequestMethod.POST)
	 public boolean recharge(@RequestBody Operation operation, @PathVariable Long codeRecharge, HttpServletRequest req) {
		//if(!test.check(req)) throw new HTTPException(403);
		System.out.println(operation.toString());
		return operationMetier.recharge(operation, codeRecharge);
	}
	
	@RequestMapping(value="/operation/listOperation/{rib}",method=RequestMethod.GET)
	public List<Operation> getOperationsByClient(@PathVariable String rib, HttpServletRequest req){
		System.out.println(rib);
		return operationMetier.getOperationByIdCompte(rib);
	}

	@RequestMapping(value="/operation/list",method=RequestMethod.GET)
	public List<Operation> getList(){
	return  operationMetier.getOperations();
	}

	@RequestMapping(value="/operation/recherche",method=RequestMethod.GET)
	public List<Operation> rechercheOperation(@RequestParam(name="mc",defaultValue="") String mc){
		System.out.println(mc);
		return  operationMetier.chercherOperation(mc);
	}


   /*@RequestMapping(value = "/operation/chercheO/{rib}",method = RequestMethod.GET)
	public List<Operation> getOperationByCompte(@RequestParam(name="mc",defaultValue="") String mc,@RequestParam(name="rib",defaultValue="")String rib){
		return operationMetier.getOperationByCompte(mc,rib);}*/
	

}
