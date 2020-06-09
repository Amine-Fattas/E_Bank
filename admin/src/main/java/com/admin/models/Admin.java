package com.admin.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Admin{
	public Long getId() {
		return id;
	}
	public Admin(){

	}

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Admin(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Id
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String username;
	private String password;

	public Admin(Long id, String nom, String prenom, String cin, String username, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.username = username;
		this.password = password;
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
}