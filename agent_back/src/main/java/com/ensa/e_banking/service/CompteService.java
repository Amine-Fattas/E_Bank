package com.ensa.e_banking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.interfacesMetier.CompteMetier;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;


@RestController
@CrossOrigin(value = "*",allowedHeaders = "*")
public class CompteService {
	
	@Autowired
	private CompteMetier compteMetier;


	HttpHeaders headers=new HttpHeaders();
	
	
	
	 @RequestMapping(value="/agent/saveCompte",method=RequestMethod.POST)
	 public Compte saveCompte(@RequestBody Compte compte,HttpServletRequest request) {

		 return compteMetier.saveCompte(compte,request);
	 }
	 
	 @RequestMapping(value="/compte/CC/{id}",method=RequestMethod.GET)
	 public Compte getCompte(@PathVariable Long id) {

		 return compteMetier.consulterCompte(id);
	 }
	 
	 @RequestMapping(value="/compte/CC/rib/{rib}",method=RequestMethod.GET)
	 public Compte getCompte(@PathVariable String rib) {
		 return compteMetier.getCompteByRib(rib);
	 }

	@RequestMapping(value="/compte/CC/client/{id}",method=RequestMethod.GET)
	public Compte getCompteByIdClient(@PathVariable Long id, HttpServletRequest req) {
	 	return compteMetier.getCompteByIdClient(id);
	}
	 

	 
	 @RequestMapping(value="/agent/listCompteActive",method=RequestMethod.GET)
		public 	List<Compte> listeCompteActive() {
			return compteMetier.getCompteActive();
		}
	 @RequestMapping(value="/agent/listCompteDesactive",method=RequestMethod.GET)
		public 	List<Compte> listeCompteDesactive() {
			return compteMetier.getCompteDesactive();
		}
	 
	@RequestMapping(value="/agent/chercherA",method=RequestMethod.GET)
		public List<Compte> chercherA(@RequestParam(name="mc",defaultValue="") String mc){
			return compteMetier.chercherA(mc);
		}

	@RequestMapping(value="/agent/chercherA/{mc}",method=RequestMethod.GET)
	public List<Compte> chercherAk(@PathVariable String mc){
		return compteMetier.chercherA(mc);
	}

	@RequestMapping(value="/agent/chercherD",method=RequestMethod.GET)
	public List<Compte> chercherD(@RequestParam(name="mc",defaultValue="") String mc){
		return compteMetier.chercherD(mc);
	}

	@RequestMapping(value="/agent/chercherD/{mc}",method=RequestMethod.GET)
	public List<Compte> chercherDk(@PathVariable String mc){
		return compteMetier.chercherD(mc);
	}
	
	 @RequestMapping(value="/agent/desactiverCompte",method=RequestMethod.PUT)
		public 	Compte desactiverCompte(@RequestBody Compte compte) {
			return compteMetier.DesactiverCompte(compte);
		}
	 
	 
	@RequestMapping(value ="/agent/activeCompte",method =RequestMethod.PUT)
	public Compte activerCompte(@RequestBody Compte compte){
	 	return compteMetier.ActiverCompte(compte);
	}
	


}
