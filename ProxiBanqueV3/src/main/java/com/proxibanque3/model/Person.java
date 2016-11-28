package com.proxibanque3.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorColumn(name = "TypePersonne")
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	// Constructeur
	public Person(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;

	}

	public Person() {
	}

}
