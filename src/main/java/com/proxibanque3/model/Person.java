package com.proxibanque3.model;

public abstract class Person {
	public String nom;
	public String prenom;

	// get set
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

	// Constructeur
	public Person(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

}
