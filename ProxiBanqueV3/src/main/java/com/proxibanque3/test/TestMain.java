package com.proxibanque3.test;

import java.util.Map;

import com.proxibanque3.dao.DaoClient;
import com.proxibanque3.dao.SQLDaoClient;
import com.proxibanque3.model.Client;

public class TestMain {

	public static void main(String[] args) {
		// DaoCompte dao = new SQLDaoCompte();
		// Compte compte = new CompteCourant(126);
		// dao.createCompteDao(compte);
		//
		DaoClient daoClient = new SQLDaoClient();
		Client c1 = new Client("Nom", "Prenom", "Adresse", "email");
		Client c2 = new Client();
		System.out.println("######################CREATION CLIENT###################");
//		daoClient.createClientDao(c1);
		Map<Long, Client> map = daoClient.readAllClientDao();
		
		System.out.println(map);

		
		

	}

}
