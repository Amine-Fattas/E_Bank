package com.ensa.e_banking.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="type_operation",discriminatorType = DiscriminatorType.STRING,length=8)



public abstract class Operation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numOperation;
	private String typeOperation;
	@Temporal(TemporalType.DATE)
	private Date dateOperation;
	private double montant;
  
	@ManyToOne
	@JoinColumn(name="id_Source")
	private Compte compteSource;
	
	
	@ManyToOne
	@JoinColumn(name="id_Destination")
	private Compte compteDestination;
	//dans la banque c'est l'agent qui effectue les operation
   
	@ManyToOne
	@JoinColumn(name="id_agent")
	private Agent agent;
	
	/*@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;*/

	
	public Long getNumOperation() {
		return numOperation;
	}

	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}


	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}


	/*public double getMontantHT() {
		return montantHT;
	}


	public void setMontantHT(double montantHT) {
		this.montantHT = montantHT;
	}

	public double getFraisOperation() {
		return fraisOperation;
	}

	public void setFraisOperation(double fraisOperation) {
		this.fraisOperation = fraisOperation;
	}*/

	public double getMontant() {
		return montant;
	}

	
	public void setMontant(double montant) {
		this.montant= montant;
	}
   

	
	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	
	public Operation() {
		super();
		
	}

	
	public String getTypeOperation() {
		return typeOperation;
	}

	
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Compte getCompteSource() {
		return compteSource;
	}

	
	public void setCompteSource(Compte compteSource) {
		this.compteSource = compteSource;
	}

	
	public Compte getCompteDestination() {
		return compteDestination;
	}

	
	public void setCompteDestination(Compte compteDestination) {
		this.compteDestination = compteDestination;
	}


	

	public Operation(Long numOperation, Date dateOperation, double montant, Compte compteSource,
			Compte compteDestination, Agent agent) {
		super();
		this.numOperation = numOperation;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compteSource = compteSource;
		this.compteDestination = compteDestination;
		this.agent = agent;
		
	}

	/*public Operation(Compte compte, Agent agent) {
		super();
		this.compte = compte;
		this.agent = agent;
	}*/
	

	
	
	
   
}