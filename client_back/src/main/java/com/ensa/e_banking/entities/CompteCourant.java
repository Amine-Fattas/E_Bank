package com.ensa.e_banking.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@DiscriminatorValue("CC")
@JsonTypeName("CC")
public class CompteCourant extends Compte{
	//private Double soldeCourant;

	public CompteCourant() {
		super();
		
	}

	public CompteCourant(Long numCompte) {
		super(numCompte);
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(String rib, Date dateCreation, boolean etat, Double fraisOuverture) {
		super(rib, dateCreation, etat, fraisOuverture);
		// TODO Auto-generated constructor stub
	}

	
	

	

	
	

}
