package com.proxibanque3.service;

import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.proxibanque3.dao.DaoClient;
import com.proxibanque3.dao.DaoCompte;
import com.proxibanque3.dao.DaoConseiller;
import com.proxibanque3.model.Client;
import com.proxibanque3.model.Compte;
import com.proxibanque3.model.CompteCourant;
import com.proxibanque3.model.CompteEpargne;
import com.proxibanque3.model.Conseiller;

/**
 * @author
 *
 * 		Cette classe comprend tout les services utilises en presentation par
 *         le conseiller depuis le simple affichage de liste juqu'� la
 *         modification des entites stockees en base de donnees
 *
 *
 *
 */
public class Service {

	@Inject
	DaoConseiller daoconseiller;
	DaoClient daoclient;
	DaoCompte daocompte;

	@PostConstruct
	public void dataBaseRempl() {
		System.out.println("******* Coucou je m'execute post construct *****");

		Client cli1 = new Client("Allen", "Woody", "57 rue de Manhattan, Hollywood", "wa@gmail.com");
		Client cli2 = new Client("Redford", "Robert", "12 rue des moines, Los Angeles", "rr@gmail.com");
		Client cli3 = new Client("Streep", "Meryl", "38 rue d'Athènes, Paris", "ms@gmail.com");

		Conseiller cons1 = new Conseiller("LeBon", "Charlotte", "admin", "admin");
		Conseiller cons2 = new Conseiller("Duris", "Romain", "login", "password");

		CompteCourant cc1 = new CompteCourant(100000);
		CompteCourant cc2 = new CompteCourant(256347);
		CompteCourant cc3 = new CompteCourant(123654789);

		CompteEpargne ce1 = new CompteEpargne(10);

		cli1.ajouterCompteListeCompte(cc1);
		cli1.ajouterCompteListeCompte(ce1);

		cli2.ajouterCompteListeCompte(cc2);

		cli3.ajouterCompteListeCompte(cc3);

		cons1.ajouterClientListeClient(cli1);
		cons1.ajouterClientListeClient(cli2);

		cons2.ajouterClientListeClient(cli3);

		daoconseiller.createConseillerDao(cons1);
		daoconseiller.createConseillerDao(cons2);

		// daocompte.createCompteDao(ce1);
		// daocompte.createCompteDao(cc3);
		// daocompte.createCompteDao(cc2);
		// daocompte.createCompteDao(cc1);

		// daoclient.createClientDao(cli3);
		// daoclient.createClientDao(cli2);
		// daoclient.createClientDao(cli1);

	}

	// Methodes qui appellent la DAO

	private Client lireClientServ(long idClient) {
		Client client = daoclient.readClientDaoById(idClient);
		return client;
	}

	private Conseiller lireConseillerServ(long idConseiller) {
		Conseiller conseiller = daoconseiller.readConseillerDaoById(idConseiller);
		return conseiller;
	}

	private Compte lireCompteServ(long numeroCompte) {
		Compte compte = daocompte.readCompteDaoById(numeroCompte);
		return compte;
	}

	private void modifierClientServ(Client client) {
		daoclient.updateClientDao(client);
	}

	// Methodes Service

	public Collection<Compte> listerComptesByClient(long idClient) {
		Client client = lireClientServ(idClient);
		Collection<Compte> listeComptes = client.getListeCompte();
		return listeComptes;
	}

	public Map<Long, Compte> listerComptes() {
		Map<Long, Compte> listeComptes = daocompte.readAllCompteDao();
		return listeComptes;
	}

	public Client obtenirClientParId(int idClient) {
		Client client = lireClientServ(idClient);
		return client;
	}

	public Compte obtenirCompteParNum(long numCompte) {
		Compte compte = lireCompteServ(numCompte);
		return compte;
	}

	public Collection<Client> listerClientsByConseiller(long idConseiller) {
		Conseiller conseiller = lireConseillerServ(idConseiller);
		Collection<Client> listeClients = conseiller.getListeClient();
		return listeClients;
	}

	public void effectuerVirement(long numCompteDebite, long numCompteCredite, double montant) {
		Compte compteDebite = lireCompteServ(numCompteDebite);
		Compte compteCredite = lireCompteServ(numCompteCredite);
		compteCredite.setSolde(compteCredite.getSolde() + montant);
		compteDebite.setSolde(compteDebite.getSolde() - montant);
		daocompte.updateCompteDao(compteCredite);
		daocompte.updateCompteDao(compteDebite);
	}

	public void modifierAdresseClient(String adresse, int idClient) {
		Client client = lireClientServ(idClient);
		client.setAdresse(adresse);
		modifierClientServ(client);
	}

	public void modifierNomClient(String nom, int idClient) {
		Client client = lireClientServ(idClient);
		client.setNom(nom);
		modifierClientServ(client);
	}

	public void modifierPrenomClient(String prenom, int idClient) {
		Client client = lireClientServ(idClient);
		client.setPrenom(prenom);
		modifierClientServ(client);
	}

	public void modifierEmailClient(String email, int idClient) {
		Client client = lireClientServ(idClient);
		client.setEmail(email);
		modifierClientServ(client);
	}

	public Map<Long, Conseiller> obtenirListeConseillers() {
		System.out.println("je passe par obtenirListe");
		return daoconseiller.readAllConseillerDao();
	}
}
