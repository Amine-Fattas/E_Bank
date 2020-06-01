package com.admin.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Admin implements Serializable{
	@Id
	private int id;
    private String nom;
    private String prenom;
    private String login;
    private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}


