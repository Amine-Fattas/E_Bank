package com.admin.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

public class Agent implements Serializable{
	private Long id;

	@Size(min=3, max=20, message="nom doit etre entre 10 et 40")
	@Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", message="ville invalid")
	private String nom;

	@Size(min=3, max=20, message="prenom doit etre entre 10 et 40")
	@Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", message="ville invalid")
	private String prenom;

	@Pattern(regexp = "^([a-zA-Z]){1,2}(\\d)+$", message="nom invalid")
	private String cin;
	private String username;
	private String password;
	private String numContrat;


	@Transient
	private Agence agence;

	private Integer numAgence;
	/*
	@OneToMany (mappedBy = "agent")
	private Collection<Client> listeClients;*/

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public Integer getNumAgence() {
		return numAgence;
	}

	public void setNumAgence(Integer numAgence) {
		this.numAgence = numAgence;
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

	public String getNumContrat() {
		return numContrat;
	}

	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Agent() {
		super();

		//AgenceServiceImpl as=new AgenceServiceImpl();
		//this.agence=as.findAgence(nomAgence);
		//this.numContrat=Integer.toString(agence.getNumAgence())+"-"+Long.toString(suffixContrat);
	}

	public Agent(Long id,String nom, String prenom, String cin, String username, String password, String numContrat, Agence agence) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.username = username;
		this.password = password;
		this.numContrat = numContrat;
		this.agence = agence;
	}

	public Agent(Long id,String nom, String prenom, String cin, String username, String password, String numContrat, Integer numAgence) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.username = username;
		this.password = password;
		this.numContrat = numContrat;
		this.numAgence = numAgence;
	}

}
