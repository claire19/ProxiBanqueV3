package com.proxibanque3.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CompteEpargne")
public class CompteEpargne extends Compte{

	public CompteEpargne(double solde, long numeroCompte) {
		super(EPARGNE, solde, numeroCompte);
		}
	
}
