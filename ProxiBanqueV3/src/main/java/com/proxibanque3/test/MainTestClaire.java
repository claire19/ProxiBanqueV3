package com.proxibanque3.test;

import java.util.Map;

import com.proxibanque3.dao.DaoClient;
import com.proxibanque3.dao.SQLDaoClient;
import com.proxibanque3.model.Client;

public class MainTestClaire {
	public static void main(String[] args) {
		Client client3 = new Client("Nom3", "Prenom3", "Adresse3", "mail3");
		Client client4 = new Client("Nom4", "Prenom4", "Adresse4", "mail4");
		
		
		
		
		
		SQLDaoClient dao = new SQLDaoClient();
		
		System.out.println("#############Nouveau################");
		Client client = new Client("Nom2", "Prenom2", "Adresse2", "mail2");
		dao.createClientDao(client);
		dao.createClientDao(client4);
		dao.createClientDao(client3);
		System.out.println("#############Nouveau################");
		client.setAdresse("Ma nouvelle adresse");
		dao.updateClientDao(client);
		System.out.println("#############Nouveau################");
		dao.deleteClientDao(client);
		System.out.println("#################Affichage de la liste#########");
		
		Map<Long, Client> map = dao.readAllClientDao();
		
		
		
	}
}
