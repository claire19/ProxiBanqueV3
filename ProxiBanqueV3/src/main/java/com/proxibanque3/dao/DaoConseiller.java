package com.proxibanque3.dao;

import java.util.Map;

import com.proxibanque3.model.Conseiller;

public interface DaoConseiller {

	void createConseillerDao(Conseiller conseiller);

	Map<Long, Conseiller> readAllConseillerDao();

	Conseiller readConseillerDaoById(long idConseiller);

	void updateConseillerDao(Conseiller conseiller);

	void deleteConseillerDao(Conseiller conseiller);

}
