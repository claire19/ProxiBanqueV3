package com.proxibanque3.model;


import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CompteCourant")
@ManagedBean
public class CompteCourant extends Compte {

	public CompteCourant(double solde) {
		super(COURANT, solde);
	}

	public CompteCourant() {
	}

}
