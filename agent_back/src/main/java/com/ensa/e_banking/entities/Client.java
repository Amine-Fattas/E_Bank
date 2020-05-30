package com.ensa.e_banking.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String cin;
	private String email;
	
	 @Column(unique = true)
	private String password;
	private String sexe;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String numTel;
	//private String profession;
	
	
	@OneToMany(mappedBy="client",cascade = CascadeType.ALL)
	private Collection<Compte> comptes;
    
	
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

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassord() {
		return password;
	}

	
	public void setPassord(String passord) {
		this.password = passord;
	}

	
	public String getSexe() {
		return sexe;
	}

	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	
	

	public String getNumTel() {
		return numTel;
	}

	
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	
	/*public String getProfession() {
		return profession;
	}

	
	public void setProfession(String profession) {
		this.profession = profession;
	}*/

	@JsonIgnore
	public Collection<Compte> getComptes() {
		return comptes;
	}

	
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Client() {
		super();
		
	}

	public Client(Long id) {
		super();
		this.id = id;
	}

	public Client(String nom, String prenom, String cin, String email, String passord, String sexe, Date dateNaissance,
			String numTel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.email = email;
		this.password = passord;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.numTel = numTel;
	}
	

	

    
}
