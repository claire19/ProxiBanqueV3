package com.proxibanque3.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
@Inheritance 
@DiscriminatorColumn(name="TypeCompte")
@ManagedBean
public abstract class Compte {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long numeroCompte;
	protected String type;
	protected double solde;
	protected static final String COURANT = "courant";

	protected static final String EPARGNE = "epargne";
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="comptes")
	protected Client client;


	public Compte() {
	}

	public Compte(String type, double solde) {
		super();
		this.type = type;
		this.solde = solde;
		
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
