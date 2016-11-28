package com.proxibanque3.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CompteCourant")
public class CompteCourant extends Compte{

	public CompteCourant(double solde) {
		super(COURANT, solde);
		}
	
}
