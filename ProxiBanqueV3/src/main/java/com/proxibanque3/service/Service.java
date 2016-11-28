package com.proxibanque3.service;


import java.util.Collection;

import javax.inject.Inject;

import com.proxibanque3.dao.DaoClient;
import com.proxibanque3.dao.DaoCompte;
import com.proxibanque3.dao.DaoConseiller;
import com.proxibanque3.model.Client;
import com.proxibanque3.model.Compte;
import com.proxibanque3.model.Conseiller;



/**
 * @author 
 *
 *Cette classe comprend tout les services utilises en presentation par le conseiller
 *depuis le simple affichage de liste juqu'� la modification des entites stockees en base de donnees
 *
 *
 *
 */
public class Service {
	
@Inject
DaoConseiller daoconseiller;
DaoClient daoclient;
DaoCompte daocompte;
	
	// Methodes qui appellent la DAO
	
	private Client lireClientServ(int idClient) {
		Client client = daoclient.readClientDaoById(idClient);
		return client;
	}
	
	private Conseiller lireConseillerServ(int idConseiller) {
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
	
	public Collection<Compte> listerComptesByClient(int idClient) {
		Client client = lireClientServ(idClient);
		Collection<Compte> listeComptes = client.getListeCompte();
		return listeComptes;
	}
	
	public Collection<Compte> listerComptes() {
	 Collection<Compte> listeComptes = daocompte.readAllCompteDao().values();
		return listeComptes;
	}
	
	public Client obtenirClientParId(int idClient){
		Client client = lireClientServ(idClient);
		return client;
	}
	
	public Compte obtenirCompteParNum(long numCompte){
		Compte compte = lireCompteServ(numCompte);
		return compte;
	}
	
	public Collection<Client> listerClientsByConseiller(int idConseiller) {
		Conseiller conseiller = lireConseillerServ(idConseiller);
		Collection<Client> listeClients = conseiller.getListeClient();
		return listeClients;
	}
	public void effectuerVirement (long numCompteDebite, long numCompteCredite, double montant) {
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
	
	public void enregistrerConseiller(Conseiller conseiller){
		daoconseiller.createConseillerDao(conseiller);
		for (Client client : conseiller.getListeClient()) {
			daoclient.createClientDao(client);
			for (Compte compte: client.getListeCompte()){
				daocompte.createCompteDao(compte);
			}
		}
		}
	
}