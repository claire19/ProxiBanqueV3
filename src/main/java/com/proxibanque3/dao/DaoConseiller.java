package com.proxibanque3.dao;

import java.util.Map;

import com.proxibanque3.model.Conseiller;


public interface DaoConseiller {

	void createConseillerDao(Conseiller conseiller);

	Map<Integer, Conseiller> readAllConseillerDao();

	Conseiller readConseillerDaoById(int idConseiller);

	void updateConseillerDao(Conseiller conseiller);

	void deleteConseillerDao(Conseiller conseiller);
	
	Integer createIdConseiller ();

}
