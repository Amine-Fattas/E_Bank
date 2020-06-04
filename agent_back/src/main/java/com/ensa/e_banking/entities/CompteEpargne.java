package com.ensa.e_banking.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@DiscriminatorValue("CE")
@JsonTypeName("CE")
public class CompteEpargne extends Compte{
  private Double remuneration;

public CompteEpargne() {
	super();

}

public CompteEpargne(Long numClient, Agent agent) {
	super(numClient, agent);
}



public CompteEpargne(String rib, Date dateCreation, boolean etat, Double fraisOuverture) {
	super(rib, dateCreation, etat, fraisOuverture);
	// TODO Auto-generated constructor stub
} 

}
