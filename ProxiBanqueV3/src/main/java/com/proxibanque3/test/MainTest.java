package com.proxibanque3.test;

import com.proxibanque3.dao.DaoClient;
import com.proxibanque3.dao.DaoCompte;
import com.proxibanque3.dao.DaoConseiller;
import com.proxibanque3.dao.SQLDaoClient;
import com.proxibanque3.dao.SQLDaoCompte;
import com.proxibanque3.dao.SQLDaoConseiller;
import com.proxibanque3.model.Client;
import com.proxibanque3.model.Compte;
import com.proxibanque3.model.CompteCourant;
import com.proxibanque3.model.CompteEpargne;
import com.proxibanque3.model.Conseiller;

public class MainTest {

	public static void main(String[] args) {
		//// DaoCompte dao = new SQLDaoCompte();
		//// Compte compte = new CompteCourant(3689);
		////
		//// Compte compte2 = new CompteCourant(89);
		//// Compte compte3 = new CompteCourant(689);
		//// dao.createCompteDao(compte);
		//// dao.createCompteDao(compte2);
		//// dao.createCompteDao(compte3);
		//// Map<Long, Compte> comptes = dao.readAllCompteDao();
		//// System.out.println(comptes);
		//// Compte compte3 = dao.readCompteDaoById(1);
		//// compte3.setSolde(0);
		////
		//// dao.updateCompteDao(compte3);
		//
		//// dao.updateCompteDao(compte3);
		//
		//
		//
		DaoConseiller daoconseiller = new SQLDaoConseiller();
		DaoCompte daocompte = new SQLDaoCompte();
		DaoClient daoclient = new SQLDaoClient();
		// ///creation
		// //Conseiller con = new Conseiller();
		// //daocon.createConseillerDao(con);
		//// Map<Long, Conseiller> cons = daocon.readAllConseillerDao();
		//// System.out.println(cons);
		// Conseiller con = daocon.readConseillerDaoById(1L);
		// System.out.println(con);
		Client cli1 = new Client("Allen", "Woody", "57 rue de Manhattan, Hollywood", "wa@gmail.com");
		Client cli2 = new Client("Redford", "Robert", "12 rue des moines, Los Angeles", "rr@gmail.com");
		Client cli3 = new Client("Streep", "Meryl", "38 rue d'Athènes, Paris", "ms@gmail.com");

		Conseiller cons1 = new Conseiller("LeBon", "Charlotte", "admin", "admin");
		Conseiller cons2 = new Conseiller("Duris", "Romain", "login", "password");

		Compte cc1 = new CompteCourant(100000);
		Compte cc2 = new CompteCourant(256347);
		Compte cc3 = new CompteCourant(123654789);

		Compte ce1 = new CompteEpargne(10);

		cli1.ajouterCompteListeCompte(cc1);
		cli1.ajouterCompteListeCompte(ce1);

		cli2.ajouterCompteListeCompte(cc2);

		cli3.ajouterCompteListeCompte(cc3);

		cons1.ajouterClientListeClient(cli1);
//		cons1.ajouterClientListeClient(cli2);

		cons2.ajouterClientListeClient(cli3);

		daoconseiller.createConseillerDao(cons1);
		daoconseiller.createConseillerDao(cons2);

//		daocompte.createCompteDao(ce1);
//		daocompte.createCompteDao(cc3);
//		daocompte.createCompteDao(cc2);
//		daocompte.createCompteDao(cc1);
//
//		daoclient.createClientDao(cli3);
//		daoclient.createClientDao(cli2);
//		daoclient.createClientDao(cli1);

	}

}
