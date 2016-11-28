package com.proxibanque3.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorValue("CompteCourant")
public class CompteCourant extends Compte{

	public CompteCourant(double solde, long numeroCompte) {
		super(COURANT, solde, numeroCompte);
		}
	
}
