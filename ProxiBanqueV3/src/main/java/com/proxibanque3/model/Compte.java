package com.proxibanque3.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity 
@Inheritance 
@DiscriminatorColumn(name="TypeCompte")
public abstract class Compte {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long numeroCompte;
	protected String type;
	protected double solde;
	protected static final String COURANT = "courant";
	protected static final String EPARGNE = "epargne";

	public Compte(String type, double solde, long numeroCompte) {
		super();
		this.type = type;
		this.solde = solde;
		this.numeroCompte = numeroCompte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

}
