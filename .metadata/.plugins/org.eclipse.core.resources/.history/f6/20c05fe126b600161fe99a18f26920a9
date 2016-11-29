package com.proxibanque3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.proxibanque3.model.Client;
import com.proxibanque3.model.Compte;
import com.proxibanque3.service.Service;

@Named
@SessionScoped
public class CompteController implements Serializable {

	private long numeroCompteDeb;
	private long numeroCompteCred;
	private double montant;

	private Client c;

	@Inject
	Service service;

	
	
	
	public List<SelectItem> getAllComptes() {
		Iterator<Compte> comptes = service.listerComptes().values().iterator();

		List<SelectItem> allComptes = new ArrayList<SelectItem>();
		while (comptes.hasNext()) {
			Compte c = comptes.next();
			SelectItem s = new SelectItem(c.getNumeroCompte(), c.toString());
			allComptes.add(s);
		}
		return allComptes;
	}

	public List<SelectItem> getComptesById() {

		Iterator<Compte> comptes = service.listerComptesByClient(c.getId()).iterator();

		List<SelectItem> comptescli = new ArrayList<SelectItem>();
		while (comptes.hasNext()) {
			Compte co = comptes.next();
			SelectItem s = new SelectItem(co.getNumeroCompte(), co.toString());
			comptescli.add(s);
		}
		return comptescli;

	}
	
	public void getVirementDone(){
		service.effectuerVirement(numeroCompteDeb, numeroCompteCred, montant);
	}
	
	
	

	public long getNumeroCompteDeb() {
		return numeroCompteDeb;
	}

	public void setNumeroCompteDeb(long numeroCompteDeb) {
		this.numeroCompteDeb = numeroCompteDeb;
	}

	public long getNumeroCompteCred() {
		return numeroCompteCred;
	}

	public void setNumeroCompteCred(long numeroCompteCred) {
		this.numeroCompteCred = numeroCompteCred;
	}

	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	
	
}
