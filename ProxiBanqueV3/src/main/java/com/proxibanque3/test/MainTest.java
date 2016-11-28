package com.proxibanque3.test;

import java.util.Map;

import com.proxibanque3.dao.DaoCompte;
import com.proxibanque3.dao.SQLDaoCompte;
import com.proxibanque3.model.Compte;
import com.proxibanque3.model.CompteCourant;

public class MainTest {

	public static void main(String[] args) {
		DaoCompte dao = new SQLDaoCompte();
//		Compte compte = new CompteCourant(3689);
//
//		Compte compte2 = new CompteCourant(89);
//		Compte compte3 = new CompteCourant(689);
//		dao.createCompteDao(compte);
//		dao.createCompteDao(compte2);
//		dao.createCompteDao(compte3);
//		Map<Long, Compte> comptes = dao.readAllCompteDao();
//		System.out.println(comptes);
		Compte compte3 = dao.readCompteDaoById(1);
		compte3.setSolde(0);
		
		dao.updateCompteDao(compte3);		
		
	}

}
