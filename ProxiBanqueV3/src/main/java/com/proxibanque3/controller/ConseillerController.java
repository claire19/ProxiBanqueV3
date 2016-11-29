package com.proxibanque3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
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
	private long id;

	@Inject
	private Service service = new Service();

	public String verifierLoginConseiller(Conseiller consInput) {
		Map<Long, Conseiller> conseillers = service.obtenirListeConseillers();
		System.out.println(conseillers);
		if (conseillers.isEmpty()) {
			return "login";
		} else {
			Iterator<Conseiller> i = conseillers.values().iterator();
			do {
				Conseiller c = (Conseiller) i.next();
				System.out.println(consInput.getLogin());
				System.out.println(c);
				if ((c.getLogin()).equals(consInput.getLogin()) && (c.getPassword()).equals(consInput.getPassword())) {
					consInput.setId(c.getId());
//					System.out.println(conseillerAVerifier.getId());
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
