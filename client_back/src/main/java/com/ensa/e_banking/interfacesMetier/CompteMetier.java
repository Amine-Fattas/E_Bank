package com.ensa.e_banking.interfacesMetier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensa.e_banking.entities.Client;
import com.ensa.e_banking.entities.Compte;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CompteMetier {
	
      public Long genererRib(int codeBanque,int codeGuichet,Long numCompte);
      public Compte saveCompte(Compte compte);
      public List<Compte> getComptes();
      public Page<Compte> chercher(
  			@RequestParam(name="mc",defaultValue="") String mc,
  			@RequestParam(name="page",defaultValue="0") int page,
  			@RequestParam(name="size",defaultValue="5") int size
  			);
      
	  public String formaterRib(int codeBanque, int codeGuichet, Long numCompte);
	  public Compte consulterCompte(Long id);
	  public Boolean DesactiverCompte(Compte compte);
	  public List<Compte> getCompteActive();

}
