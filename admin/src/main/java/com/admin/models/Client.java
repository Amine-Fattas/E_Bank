package com.admin.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Client implements Serializable {

    @Id
    private int id;
    @OneToOne
    private CompteBancaire compteC;
    @OneToOne
    private CompteBancaire compteE;
    @ManyToOne
    private Agent agent;
    private Long numAgent;
    private String nom;
    private String prenom;
    private String cin;
    private String login;
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public CompteBancaire getCompteC() {
        return compteC;
    }

    public void setCompteC(CompteBancaire compteC) {
        this.compteC = compteC;
    }

    public CompteBancaire getCompteE() {
        return compteE;
    }

    public void setCompteE(CompteBancaire compteE) {
        this.compteE = compteE;
    }




    public Long getNumAgent() {
        return numAgent;
    }

    public void setNumAgent(Long agent) {
        this.numAgent = agent;
    }

    public Client() {
            super();
            // TODO Auto-generated constructor stub
        }



}
