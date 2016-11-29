package com.proxibanque3.controller;

import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.proxibanque3.model.Conseiller;
import com.proxibanque3.service.Service;

@ManagedBean
@SessionScoped
public class ConseillerController {
	private String login, password;

	// @Inject
	private Service service;

	public String verifierLoginConseiller(Conseiller conseillerAValider) {
		Iterable<Conseiller> conseillers = service.obtenirListeConseillers();
		// faire une boucle sur la liste de conseiller pour verifier si login
		// conseiller = login liste
		Iterator<Conseiller> i = conseillers.iterator();
		String connexion = null;
		do{
		Conseiller c = (Conseiller) i.next();
			if()
			
		
		}while (conseillers.iterator().hasNext() || connexion == null );
		return "accueil";
	}

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

}
