package com.admin.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


public class CompteBancaire implements Serializable {

    private String typeCompte;
    private Long numCompte;
    private String rib;
    private Date dateCreation;
    private Double solde;
    private boolean etat;
    private Double fraisOuverture;


    //private Client client;
    private Long idClient;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    private Agent agent;

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public Long getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(Long numCompte) {
        this.numCompte = numCompte;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Double getFraisOuverture() {
        return fraisOuverture;
    }

    public void setFraisOuverture(Double fraisOuverture) {
        this.fraisOuverture = fraisOuverture;
    }



    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }


    public CompteBancaire(String typeCompte, Long numCompte, String rib, Date dateCreation, Double solde, boolean etat, Double fraisOuverture, Client client, Agent agent) {
        this.typeCompte = typeCompte;
        this.numCompte = numCompte;
        this.rib = rib;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.etat = etat;
        this.fraisOuverture = fraisOuverture;

        this.agent = agent;
    }

    public CompteBancaire() {

    }
}
