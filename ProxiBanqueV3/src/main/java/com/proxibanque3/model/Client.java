package com.proxibanque3.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Client extends Person {
	
	public String adresse;
	public String email;
	@ManyToOne
	@JoinColumn(name="listeClient")
	public Conseiller conseiller;

	private Map<Long, Compte> comptes = new HashMap<>();

	public Client(String nom, String prenom, long id, String adresse, String email) {
		super(nom, prenom, id);
	
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


	// obtenir la liste des comptes associés au client

	public Collection<Compte> getListeCompte() {
		return comptes.values();
	}

	// on ajoute un compte à la liste du client
	public void ajouterCompteListeCompte(Compte compte) {
		comptes.put(compte.getNumeroCompte(), compte);
	}
	// on supprime un compte de la liste du client

	public void supprimerCompteListeCompte(Compte compte) {
		comptes.remove(compte).getNumeroCompte();
	}
}
