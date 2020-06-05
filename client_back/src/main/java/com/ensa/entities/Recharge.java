package com.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Recharge {
	

	private Long codeRecharge;
	private Double valeur;
	
	
	
	public Recharge() {
		super();
	}


	public Recharge(Long codeRecharge, Double valeur) {
		super();
		this.codeRecharge = codeRecharge;
		this.valeur = valeur;
	}




	public Long getCodeRecharge() {
		return codeRecharge;
	}


	public void setCodeRecharge(Long codeRecharge) {
		this.codeRecharge = codeRecharge;
	}


	public Double getValeur() {
		return valeur;
	}


	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}


	@Override
	public String toString() {
		return "Recharge [codeRecharge=" + codeRecharge + ", valeur=" + valeur + "]";
	}


	
	
	
	

}
