package com.proxibanque3.dao;

import java.util.Map;

import com.proxibanque3.model.Compte;


public interface DaoCompte {
	
	void createCompteDao(Compte compte);

	Map<Long, Compte> readAllCompteDao();

	Compte readCompteDaoById(long numeroCompte);

	void updateCompteDao(Compte compte);

	void deleteCompteDao(Compte compte);
	
	
}
