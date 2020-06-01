package com.admin.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
//@Builder(builderMethodName = "builder")
// pas utlise lombok genere gett et setters
public class Agent implements Serializable{
    private String img;
	private String nom;
	private String prenom;
	private String cin;
	private String login;
	private String password;
    @Id
	private Long suffixContrat;
	private String numContrat;
	@ManyToOne
	private Agence agence;
	//private String nomAgence;
	@OneToMany (mappedBy = "agent")
	private Collection<Client> listeClients;




	public Agent() {
		super();

		//AgenceServiceImpl as=new AgenceServiceImpl();
		//this.agence=as.findAgence(nomAgence);
		//this.numContrat=Integer.toString(agence.getNumAgence())+"-"+Long.toString(suffixContrat);
	}


	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public long getSuffixContrat() {
		return suffixContrat;
	}

	public void setSuffixContrat(Long suffixContrat) {
		this.suffixContrat = suffixContrat;
	}

	public String getNumContrat() {
		return numContrat;
	}

	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;

	}


	//public String getNomAgence() { return nomAgence; }

	//public void setNomAgence(String nomAgence) {this.nomAgence = nomAgence;}

	public Collection<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(Collection<Client> listeClients) {
		this.listeClients = listeClients;
	}




}
