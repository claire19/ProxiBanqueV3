package com.proxibanque3.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.proxibanque3.model.Client;
import com.proxibanque3.model.Conseiller;
import com.proxibanque3.service.Service;

@Named
@SessionScoped
public class ConseillerController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login, password;

	@Inject
	private Service service = new Service();

	public String verifierLoginConseiller(Conseiller conseillerAValider) {
		Map<Long, Conseiller> conseillers = service.obtenirListeConseillers();
		if (conseillers.isEmpty()) {
			return "login";
		} else {
			Iterator<Conseiller> i = conseillers.values().iterator();
			do {
				Conseiller c = (Conseiller) i.next();
				if (conseillerAValider.getLogin().equals(c.getLogin())
						&& conseillerAValider.getPassword().equals(c.getPassword())) {
					i = null;
					return "listeClients";
				}

			} while (i.hasNext());
			return "login";
		}
	}

	// get et set

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
