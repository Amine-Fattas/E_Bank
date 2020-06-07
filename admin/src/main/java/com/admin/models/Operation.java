package com.admin.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


public class Operation implements Serializable {


    private Long numOperation;
    private String typeOperation;
    private Date dateOperation;
    private double montant;


    private CompteBancaire compteSource;



    private CompteBancaire compteDestination;



    private Agent agent;


    public Long getNumOperation() {
        return numOperation;
    }

    public void setNumOperation(Long numOperation) {
        this.numOperation = numOperation;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public CompteBancaire getCompteSource() {
        return compteSource;
    }

    public void setCompteSource(CompteBancaire compteSource) {
        this.compteSource = compteSource;
    }

    public CompteBancaire getCompteDestination() {
        return compteDestination;
    }

    public void setCompteDestination(CompteBancaire compteDestination) {
        this.compteDestination = compteDestination;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }


    public Operation(Long numOperation, String typeOperation, Date dateOperation, double montant, CompteBancaire compteSource, CompteBancaire compteDestination, Agent agent) {
        this.numOperation = numOperation;
        this.typeOperation = typeOperation;
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
        this.agent = agent;
    }


   public Operation(){}
}
