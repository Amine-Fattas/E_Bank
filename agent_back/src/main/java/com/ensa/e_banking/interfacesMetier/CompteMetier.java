package com.ensa.e_banking.interfacesMetier;

import java.util.List;

import org.springframework.data.domain.Page;
import com.ensa.e_banking.entities.Compte;


public interface CompteMetier {
	
      public Long genererRib(int codeBanque,int codeGuichet,Long numCompte);
      public Compte saveCompte(Compte compte);
      public Page<Compte> getComptes(int page);
      public List<Compte> chercherA(String mc);
	  public String formaterRib(int codeBanque, int codeGuichet, Long numCompte);
	  public Compte consulterCompte(Long id);
	  public Compte DesactiverCompte(Compte compte);
	  public List<Compte> getCompteActive();
	  public List<Compte> getCompteDesactive();
      public List<Compte> chercherD(String mc);
     
      
	


}
