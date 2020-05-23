package com.ensa.e_banking.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Entity
@Table

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",discriminatorType = DiscriminatorType.STRING,length=2)


@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="typeCompte")
@JsonSubTypes({
		@Type(name="CC",value=CompteCourant.class),
		@Type(name="CE",value=CompteEpargne.class)
})

public abstract class Compte implements Serializable{
	
	@Id
	private Long numCompte;
	private String rib;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private Double solde;
	private boolean etat;
	private Double fraisOuverture;
	
	
    @ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
   
	@ManyToOne
	@JoinColumn(name="id_agent")
	private Agent agent;
	
   
//	@OneToMany(mappedBy="compteSource",cascade = CascadeType.ALL, orphanRemoval = true)
//	private Collection<Operation> operations;
	
	
	// !!! J'ai divisé cette Collection en 2 mappings pour les 2 comptes src et dst
	@OneToMany(mappedBy="compteSource",cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Operation> retraits;
	
	@OneToMany(mappedBy="compteDestination",cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Operation> versements;
	

	
	

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

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	public Agent getAgent() {
		return agent;
	}

	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
     
	@JsonIgnore
	public Collection<Operation> getRetraits() {
		return retraits;
	}


	public void setRetraits(Collection<Operation> retraits) {
		this.retraits = retraits;
	}

	@JsonIgnore
	public Collection<Operation> getVersements() {
		return versements;
	}


	public void setVersements(Collection<Operation> versements) {
		this.versements = versements;
	}

	
	public Compte() {
	super();
	}
	
	
	


	public Compte(Long numCompte) {
		super();
		this.numCompte = numCompte;
	}


	public Compte(String rib,Date dateCreation,boolean etat,Double fraisOuverture) {
		super();
		this.rib = rib;
		this.dateCreation = dateCreation;
		this.etat = etat;
		this.fraisOuverture = fraisOuverture;
	}


	public Compte( Client client,Agent agent) {
		super();
		this.client = client;
		this.agent = agent;
		
	}
	
	
	

}
