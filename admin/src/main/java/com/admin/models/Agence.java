package com.admin.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
public class Agence implements Serializable {

    @Id
    private Integer numAgence; // code guichet

    @Size(min=10, max=40, message="nom doit etre entre 10 et 40")
    @Pattern(regexp = "^((?![\\^!@#$*~ <>?]).)((?![\\^!@#$*~<>?]).){0,38}((?![\\^!@#$*~ <>?]).)$", message="nom invalid")
    private String nomAgence;

    @Size(min=10, max=80, message="adresse doit etre entre 10 et 80")
    @Pattern(regexp = "^((?![\\^!@#$*~ <>?]).)((?![\\^!@#$*~<>?]).){0,78}((?![\\^!@#$*~ <>?]).)$", message="adresse invalid")
    private String adresse;

    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", message="ville invalid")
    private String ville;

    @Pattern(regexp = "(\\+212|0)([ \\-_/]*)(\\d[ \\-_/]*){9}", message="téléphone invalid")
    private String tel;

    static private int code_banque=30045;


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

