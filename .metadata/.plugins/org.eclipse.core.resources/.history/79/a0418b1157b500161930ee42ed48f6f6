package com.proxibanque3.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idClient;
	public String adresse;
	public String email;

	private Map<Long, Compte> listeCompte = new HashMap<>();

	public Client(String nom, String prenom, long idClient, String adresse, String email) {
		super(nom, prenom);
		this.idClient = idClient;
		this.adresse = adresse;
		this.email = email;
	}

	// get set

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	// obtenir la liste des comptes associ�s au client

	public Collection<Compte> getListeCompte() {
		return listeCompte.values();
	}

	// on ajoute un compte � la liste du client
	public void ajouterCompteListeCompte(Compte compte) {
		listeCompte.put(compte.getNumeroCompte(), compte);
	}
	// on supprime un compte de la liste du client

	public void supprimerCompteListeCompte(Compte compte) {
		listeCompte.remove(compte).getNumeroCompte();
	}
}
