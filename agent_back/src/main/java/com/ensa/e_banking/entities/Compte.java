package com.ensa.e_banking.entities;


import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;



@Entity
@Table

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",discriminatorType = DiscriminatorType.STRING,length=2)


@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="typeCompte")
@JsonSubTypes({
		@Type(name="CC",value=CompteCourant.class),
		@Type(name="CE",value=CompteEpargne.class)
})

public  class Compte{
	
	@Id 
	private Long numCompte;
	private String rib;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private Double solde;
	private boolean etat;
	private Double fraisOuverture;



	@Transient
	private Client client;

	private Long idClient;

	
   
   // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToOne
    @JoinColumn(name="id_agent")
	private Agent agent;
	
   
	@OneToMany(mappedBy="compteSource",cascade = CascadeType.ALL)
	private Collection<Operation> compteSource;
	
	@OneToMany(mappedBy="compteDestination",cascade = CascadeType.ALL)
	private Collection<Operation> compteDestination;
	
//	Constructors

	public Compte() {
		super();
	}



	public Compte(String rib,Date dateCreation,boolean etat,Double fraisOuverture) {
		super();
		this.rib = rib;
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.fraisOuverture = fraisOuverture;
	}


	public Compte(Client client,Agent agent) {
		super();
		this.client = client;
		this.agent = agent;

	}


//	Getters & Setter

	public Long getNumCompte() {
		return numCompte;
	}

	
	public void setNumCompte(Long numCompte) {
		this.numCompte = numCompte;
	}

	
	
	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
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
     
	@JsonIgnore
	public Collection<Operation> getCompteSource() {
		return compteSource;
	}


	public void setCompteSource(Collection<Operation> compteSource) {
		this.compteSource = compteSource;
	}

	@JsonIgnore
	public Collection<Operation> getCompteDestination() {
		return compteDestination;
	}


	public void setCompteDestination(Collection<Operation> compteDestination) {
		this.compteDestination = compteDestination;
	}

	


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getIdClient() {
		return idClient;
	}


	public void setIdClient(Long idClient) {
		this.idClient = idClient;

	}
}
