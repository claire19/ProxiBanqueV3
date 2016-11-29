package com.proxibanque3.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@ManagedBean
@SessionScoped
public class Client implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "clients")
	private Conseiller conseiller;

	@OneToMany(mappedBy = "client", cascade = { CascadeType.ALL })
	private Map<Long, Compte> comptes = new HashMap<>();

	public Client(String nom, String prenom, String adresse, String email) {
		this.nom = nom;
		this.prenom = prenom;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		compte.setClient(null);
		comptes.remove(compte.getNumeroCompte());

	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	@Override
	public String toString() {
		return "nom=" + nom + ", prenom=" + prenom ;
	}

}
