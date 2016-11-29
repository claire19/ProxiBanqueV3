package com.proxibanque3.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@ManagedBean
@SessionScoped
@Entity
public class Conseiller{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	private String login;
	private String password;

	@OneToMany(mappedBy = "conseiller", cascade={CascadeType.ALL})
	private Map<Long, Client> clients = new HashMap<>();


	// Constructeur
	public Conseiller(String nom, String prenom, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	public Conseiller() {
	}

	// get set
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	// obtenir la liste des clients associes au conseiller

	public Collection<Client> getClients() {
		System.out.println("j'essaye" + clients.values());
		return clients.values();
	}

	// on ajoute un client a la liste du conseiller
	public void ajouterClientListeClient(Client client) {
		client.setConseiller(this);
		clients.put(client.getId(), client);
	}
	// on supprime un client de la liste du conseiller

	public void supprimerClientListeClient(Client client) {
		client.setConseiller(null);
		clients.remove(client).getId();
	}

		
}
