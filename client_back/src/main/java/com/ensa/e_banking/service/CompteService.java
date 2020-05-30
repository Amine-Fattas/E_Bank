package com.ensa.e_banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.interfacesMetier.CompteMetier;
import com.fasterxml.jackson.databind.JsonMappingException;



@RestController
@CrossOrigin("*")
public class CompteService {
	
	@Autowired
	private CompteMetier compteMetier;
	
	
	 @RequestMapping(value="/compte/ajoutCompte",method=RequestMethod.POST)
	 public Compte saveCompte(@RequestBody Compte compte) {
		 return compteMetier.saveCompte(compte);
	 }
	 
	 @RequestMapping(value="/compte/listCompte",method=RequestMethod.GET)
	 public List<Compte> listCompte() {	 
		 return compteMetier.getCompteActive();
	 }
	 
	 @RequestMapping(value="/compte/CC/{id}",method=RequestMethod.GET)
	 public Compte getCompte(@PathVariable Long id) {
		 return compteMetier.consulterCompte(id);
	 }
	 
	
	
	

}
