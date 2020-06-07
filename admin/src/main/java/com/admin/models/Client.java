package com.admin.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


public class Client implements Serializable {


    private Long id;
    private String nom;
    private String prenom;

    private String cin;
    private String username;


    private String password;
    private String sexe;


    private Date dateNaissance;
    private String numTel;



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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public Client(String nom, String prenom, String cin, String username, String password, String sexe, Date dateNaissance, String numTel) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.username = username;
        this.password = password;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.numTel = numTel;
    }

    public Client(){}
}
