package com.ensa.e_banking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.interfacesMetier.CompteMetier;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin(value = "*",allowedHeaders = "*")
public class CompteService {
	
	@Autowired
	private CompteMetier compteMetier;

	@Autowired
	private test test;
	
	
	
	 @RequestMapping(value="/compte/saveCompte",method=RequestMethod.POST)
	 public Compte saveCompte(@RequestBody Compte compte) {
		 System.out.println("ajout");
		 return compteMetier.saveCompte(compte);
	 }
	 
	 @RequestMapping(value="/compte/CC/{id}",method=RequestMethod.GET)
	 public Compte getCompte(@PathVariable Long id) {
//	 	if(!test.check(req)){
//	 		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
		 return compteMetier.consulterCompte(id);
	 }
	 
	 @RequestMapping(value="/compte/CC/rib/{rib}",method=RequestMethod.GET)
	 public Compte getCompte(@PathVariable String rib) {
		 return compteMetier.getCompteByRib(rib);
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
