package com.ensa.e_banking.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Agent {
	@Id
	/*@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String username;
	private String password;
	private String numContrat;

	private int numAgence;
	

   
	public Agent(Long id, String nom, String prenom, String cin, String username, String password, int numAgence) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.username = username;
		this.password = password;
		this.numAgence=numAgence;
	}


	public Agent(String username, String password, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		
	}




	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	
	public Long getId() {
		return id;
	}


	
	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	
	public void setNom(String nom) {
		this.nom = nom;
	}


	
	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	
	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}




	public Agent() {
		super();
		
	}



	public Agent(Long id, String nom, String prenom, String cin, int numAgence) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.numAgence = numAgence;
	}



	public Agent(Long id) {
		super();
		this.id = id;
	}

	public String getNumContrat() {
		return numContrat;
	}

	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}

	public int getNumAgence() {
		return numAgence;
	}

	public void setNumAgence(int numAgence) {
		this.numAgence = numAgence;
	}
}
