package com.proxibanque3.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@ManagedBean
public class Conseiller extends Person {

	private String login;
	private String password;

	@OneToMany(mappedBy = "conseiller", cascade={CascadeType.PERSIST})
	private Map<Long, Client> clients = new HashMap<>();

	// Constructeur
	public Conseiller(String nom, String prenom, String login, String password) {
		super(nom, prenom);
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

	// obtenir la liste des clients associ�s au conseiller

	public Collection<Client> getListeClient() {
		return clients.values();
	}

	// on ajoute un client � la liste du conseiller
	public void ajouterClientListeClient(Client client) {
		clients.put(client.getId(), client);
		client.setConseiller(this);
	}
	// on supprime un client de la liste du conseiller

	public void supprimerClientListeClient(Client client) {
		clients.remove(client).getId();
	}
}
