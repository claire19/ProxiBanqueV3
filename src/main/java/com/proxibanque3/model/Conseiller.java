package com.proxibanque3.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Conseiller extends Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idConseiller;
	private String login;
	private String password;
	

	private Map<Long, Client> listeClient = new HashMap<>();

	// Constructeur
	public Conseiller(String nom, String prenom, String login, String password, long idConseiller) {
		super(nom, prenom);
		this.login = login;
		this.password = password;
		this.idConseiller = idConseiller;
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

	public long getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(long idConseiller) {
		this.idConseiller = idConseiller;
	}

	// obtenir la liste des clients associ�s au conseiller

	public Collection<Client> getListeClient() {
		return listeClient.values();
	}

	// on ajoute un client � la liste du conseiller
	public void ajouterClientListeClient(Client client) {
		listeClient.put(client.getIdClient(), client);
	}
	// on supprime un client de la liste du conseiller

	public void supprimerClientListeClient(Client client) {
		listeClient.remove(client).getIdClient();
	}
}
