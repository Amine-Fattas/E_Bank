package com.ensa.e_banking.interfacesImpl;


import java.util.Date;
import java.util.List;


import com.ensa.e_banking.service.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.e_banking.dao.CompteRepository;
import com.ensa.e_banking.entities.Agence;
import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.entities.Compte;
import com.ensa.e_banking.interfacesMetier.ClientMetier;
import com.ensa.e_banking.interfacesMetier.CompteMetier;
import org.springframework.web.client.RestTemplate;


@Service
public class CompteMetierImp implements CompteMetier{


	@Autowired
	private HomeController homeController;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder=new  BCryptPasswordEncoder();


	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	ClientMetier clientMetier;

	@Autowired
	RestTemplate restTemplate;
	
    Long numCompte;
	private String url = "http://localhost:8082";

	
	Agence agence=new Agence();
	
	@Override
	public Long genererRib(int codeBanque, int codeGuichet, Long numCompte) {
		return 97-(((89*codeBanque)+(15*codeGuichet)+(3*numCompte)) % 97);
	}

	@Override
	public Compte saveCompte(Compte compte){
		compte.getClient().setPassword(clientMetier.genererPassword());
//        clientMetier.saveClient(compte.getClient());
		restTemplate.postForObject(url+"/client/ajoutClient", compte.getClient(), Client.class);
        compte.setDateCreation(new Date());
        compte.setSolde(0.0);
        compte.setEtat(true);
        compte.setFraisOuverture(20.0);
        if(compteRepository.dernierEnregistrement() != null) {
      
        numCompte=compteRepository.dernierEnregistrement()+1;
        }
        else {numCompte=1L;}
  
        compte.setNumCompte(numCompte);
        compte.setRib(formaterRib(agence.getCode_banque(),homeController.currentAgent().getNumAgence(),numCompte));
        System.out.println("done");
		compteRepository.save(compte);
		return compte;
	}

	@Override
	public Page<Compte> getComptes(int page) {
		
		return compteRepository.findAll(PageRequest.of(page, 7));
	}

	@Override
	public List<Compte> chercherA(String mc) {
		return compteRepository.chercherA("%"+mc+"%");
	}
	

	@Override
	public Compte consulterCompte(Long id) {
		return  compteRepository.findById(id).get();
	}
	
	@Override
	public Compte getCompteByRib(String rib) {
		System.out.println(rib);
		Compte compte= compteRepository.findCompteByRib(rib);
		System.out.println(compte);
		return  compte;
	}



	@Override
	public Compte getCompteByIdClient(Long idClient) {
		return compteRepository.findCompteByIdClient(idClient);
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
	public Compte DesactiverCompte(Compte compte) {
	           compte.setEtat(false);
		   		return compteRepository.save(compte);
	}

	@Override
	public Compte ActiverCompte(Compte compte) {
		compte.setEtat(true);
		return compteRepository.save(compte);
	}

	@Override
	public List<Compte> getCompteActive() {
		return compteRepository.findCompteActive();
		}

	@Override
	public List<Compte> getCompteDesactive() {
		return compteRepository.findCompteDesactive();
	}

	@Override
	public List<Compte> chercherD(String mc) {
		
		return compteRepository.chercherD("%"+mc+"%");
	}


   



    }
