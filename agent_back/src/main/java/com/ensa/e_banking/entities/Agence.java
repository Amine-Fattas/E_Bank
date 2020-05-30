package com.ensa.e_banking.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Agence {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
    //il faut avoir des taux predefini comme pour le taux de virement

	private int numAgence;
	
	//nom Banque A,J = 1 ; B,K,S = 2 ; C,L,T = 3 ; D,M,U = 4 ; E,N,V = 5 F,O,W = 6 ; G,P,X = 7 ; H,Q,Y = 8 ; I,R,Z = 9
	
	private String nomAgence;
	// 5 chiffre
	private int codeBanque=30045;
	// 5 chiffre
	private int codeGuichet=23415;
	
	private String adresse;
	private String ville;
	
	
	@OneToMany(mappedBy="agence",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Collection<Agent> agent;

	public int getNumAgence() {
		return numAgence;
	}

	
	public void setNumAgence(int numAgence) {
		this.numAgence = numAgence;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	
	public int getCodeBanque() {
		return codeBanque;
	}

	public void setCodeBanque(int codeBanque) {
		this.codeBanque = codeBanque;
	}

	public int getCodeGuichet() {
		return codeGuichet;
	}

	
	public void setCodeGuichet(int codeGuichet) {
		this.codeGuichet = codeGuichet;
	}

	
	public String getAdresse() {
		return adresse;
	}

	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	public String getVille() {
		return ville;
	}

	
	public void setVille(String ville) {
		this.ville = ville;
	}

	@JsonIgnore
	public Collection<Agent> getAgent() {
		return agent;
	}

	public void setAgent(Collection<Agent> agent) {
		this.agent = agent;
	}


	public Agence() {
		super();
		
	}


	public Agence(int numAgence, String nomAgence, int codeBanque, int codeGuichet, String adresse, String ville
			) {
		super();
		this.numAgence = numAgence;
		this.nomAgence = nomAgence;
		this.codeBanque = codeBanque;
		this.codeGuichet = codeGuichet;
		this.adresse = adresse;
		this.ville = ville;
		
	}


	public Agence(int numAgence) {
		super();
		this.numAgence = numAgence;
	}
	
	
	
}
