package com.ensa.entities;

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


public class Agence {
	
    //il faut avoir des taux predefini comme pour le taux de virement

	private int numAgence;//code guichet
	
	//nom Banque A,J = 1 ; B,K,S = 2 ; C,L,T = 3 ; D,M,U = 4 ; E,N,V = 5 F,O,W = 6 ; G,P,X = 7 ; H,Q,Y = 8 ; I,R,Z = 9
	
	private String nomAgence;
	// 5 chiffre
	private int code_banque=30045;
	
	
	
	private String adresse;
	private String ville;
	private String tel;
	
	
	

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
		return code_banque;
	}

	public void setCodeBanque(int codeBanque) {
		this.code_banque = codeBanque;
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

	


	public Agence() {
		super();
		
	}


	public Agence(int numAgence, String nomAgence, int codeBanque,String adresse, String ville
			) {
		super();
		this.numAgence = numAgence;
		this.nomAgence = nomAgence;
		this.code_banque = codeBanque;
		
		this.adresse = adresse;
		this.ville = ville;
		
	}


	public Agence(int numAgence) {
		super();
		this.numAgence = numAgence;
	}
	
	
	
}
