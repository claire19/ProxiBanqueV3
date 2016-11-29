package com.proxibanque3.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Client extends Person {

	private String adresse;
	private String email;
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "clients")
	private Conseiller conseiller;

	@OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST })
	private Map<Long, Compte> comptes = new HashMap<>();

	public Client(String nom, String prenom, String adresse, String email) {
		super(nom, prenom);
		this.adresse = adresse;
		this.email = email;
	}

	public Client() {

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
		compte.setClient(this);
	}
	// on supprime un compte de la liste du client

	public void supprimerCompteListeCompte(Compte compte) {
		comptes.remove(compte.getNumeroCompte());
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
}
