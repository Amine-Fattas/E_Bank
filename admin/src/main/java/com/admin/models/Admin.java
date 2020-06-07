package com.admin.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Admin{

	public Admin(Long id, String nom, String prenom, String cin, String username, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.userName = username;
		this.password = password;
	}

	// @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String userName;
	private String password;




/* 	public Admin(String username, String password, boolean enable) {
		super();
		this.username = username;
		this.password = password;

	}
*/

	public String getUsername() {
		return userName;
	}


	public void setUsername(String username) {
		this.userName = username;
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

	public Admin() {
		super();

	}



	/*public Admin(Long id, String nom, String prenom, String cin, Agence agence) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;

	}*/



	public Admin(Long id) {
		super();
		this.id = id;
	}


}



