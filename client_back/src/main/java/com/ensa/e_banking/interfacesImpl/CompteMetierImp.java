package com.ensa.e_banking.interfacesImpl;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ensa.e_banking.dao.CompteRepository;
import com.ensa.e_banking.entities.Agence;
import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.interfacesMetier.CompteMetier;
import com.fasterxml.jackson.core.JsonProcessingException;
@Service
public class CompteMetierImp implements CompteMetier{

	@Autowired
	CompteRepository compteRepository;
    Long numCompte;

	
	Agence agence=new Agence();
	
	@Override
	public Long genererRib(int codeBanque, int codeGuichet, Long numCompte) {
		
		return 97-(((89*codeBanque)+(15*codeGuichet)+(3*numCompte)) % 97);
		
	}
    
	@Override
	public Compte saveCompte(Compte compte){
		
        compte.setDateCreation(new Date());
        compte.setSolde(0.0);
        compte.setEtat(true);
        System.out.println("hello");
        compte.setFraisOuverture(20.0);
 
        numCompte=compteRepository.dernierEnregistrement()+1;
        System.out.println(numCompte);
        compte.setNumCompte(numCompte);
        compte.setRib(formaterRib(agence.getCodeBanque(),agence.getCodeGuichet(),numCompte));
        
		return compteRepository.save(compte);
	}

	@Override
	public List<Compte> getComptes() {
		
		return compteRepository.findAll();
	}

	@Override
	public Page<Compte> chercher(String mc, int page, int size) {
		return compteRepository.chercher("%"+mc+"%",PageRequest.of(page, size,Sort.by("etat")));
	}
	

	@Override
	public Compte consulterCompte(Long id) {
		return  compteRepository.findById(id).get();
	}

	@Override
	public String formaterRib(int codeBanque, int codeGuichet,Long numCompte) {
	    Long ribCle=genererRib(codeBanque, codeGuichet, numCompte);
		String rib=Integer.toString(codeBanque)+" "+Integer.toString(codeGuichet)
		+" "+String.format("%011d", numCompte)
		+" "+Long.toString(ribCle);
		
		return rib;
	}

	@Override
	public Boolean DesactiverCompte(Compte compte) {
	           compte.setEtat(false);
		       return compte.isEtat();
	}

	@Override
	public List<Compte> getCompteActive() {
		return compteRepository.findCompteActive();
		}



}
