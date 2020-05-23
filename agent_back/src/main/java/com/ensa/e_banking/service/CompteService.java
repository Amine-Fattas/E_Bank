package com.ensa.e_banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.interfacesMetier.CompteMetier;
import com.fasterxml.jackson.databind.JsonMappingException;

//import junit.framework.Test;

@RestController
@CrossOrigin("*")
public class CompteService {
	
	@Autowired
	private CompteMetier compteMetier;
	
	
	 @RequestMapping(value="/compte/ajoutCompte",method=RequestMethod.POST)
	 public Compte saveCompte(@RequestBody Compte compte) {
		 System.out.println("ajout");
		 return compteMetier.saveCompte(compte);
	 }
	 
	/* @RequestMapping(value="/compte/listCompte",method=RequestMethod.GET)
	 public List<Compte> listCompte() {
		 
		 return compteMetier.getCompteActive();
	 }*/
	 
	/* @RequestMapping(value="/compte/listCompte",method=RequestMethod.GET)
		public Page<Compte> listeCompte(@RequestParam(name="page",defaultValue="0") int page) {
			return compteMetier.getComptes(page);
		}*/
	 
	 @RequestMapping(value="/compte/listCompteActive",method=RequestMethod.GET)
		public 	List<Compte> listeCompteActive() {
			return compteMetier.getCompteActive();
		}
	 @RequestMapping(value="/compte/listCompteDesactive",method=RequestMethod.GET)
		public 	List<Compte> listeCompteDesactive() {
			return compteMetier.getCompteDesactive();
		}
	 
	@RequestMapping(value="/compte/chercherA",method=RequestMethod.GET)
		public List<Compte> chercherA(@RequestParam(name="mc",defaultValue="") String mc){
			return compteMetier.chercherA(mc);
		}
	@RequestMapping(value="/compte/chercherD",method=RequestMethod.GET)
	public List<Compte> chercherD(@RequestParam(name="mc",defaultValue="") String mc){
		return compteMetier.chercherD(mc);
	}
	
	 @RequestMapping(value="/compte/desactiverCompte",method=RequestMethod.PUT)
		public 	Compte desactiverCompte(@RequestBody Compte compte) {
			return compteMetier.DesactiverCompte(compte);
		}
	 
	 
	
	
	 
	
	
	

}