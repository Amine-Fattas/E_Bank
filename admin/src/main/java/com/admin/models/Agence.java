package com.admin.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Agence implements Serializable {

    @Id
    private Integer numAgence; // code guichet
    private String nomAgence;
    private String adresse;
    private String ville;
    private String tel;
    static private int code_banque= 435;
    /*@OneToMany
    private Collection<Agent> agents;*/



    public static int getCode_banque() {
        return code_banque;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Agence(Integer numAgence) {
        this.numAgence = numAgence;
    }

    public Agence() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Integer getNumAgence() {
        return numAgence;
    }
    public void setNumAgence(int numAgence) {
        this.numAgence = numAgence;
    }
    public String getNomAgence() {
        return nomAgence;
    }
    public void setNomAgence(String nomAgence) {
        this.nomAgence= nomAgence;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse= adresse;
    }


}

