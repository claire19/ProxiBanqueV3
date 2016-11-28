package com.proxibanque3.test;

import java.util.Map;

import com.proxibanque3.dao.DaoConseiller;
import com.proxibanque3.dao.SQLDaoConseiller;
import com.proxibanque3.model.Conseiller;

public class MainTest {

	public static void main(String[] args) {
//		DaoCompte dao = new SQLDaoCompte();
//		Compte compte = new CompteCourant(3689);
//
//		Compte compte2 = new CompteCourant(89);
//		Compte compte3 = new CompteCourant(689);
//		dao.createCompteDao(compte);
//		dao.createCompteDao(compte2);
//		dao.createCompteDao(compte3);
//		Map<Long, Compte> comptes = dao.readAllCompteDao();
//		System.out.println(comptes);
//		Compte compte3 = dao.readCompteDaoById(1);
//		compte3.setSolde(0);
//		
//		dao.updateCompteDao(compte3);		
		
		
		DaoConseiller daocon = new SQLDaoConseiller();
		///creation
		//Conseiller con = new Conseiller();
		//daocon.createConseillerDao(con);
//		Map<Long, Conseiller> cons = daocon.readAllConseillerDao();
//		System.out.println(cons);
		Conseiller con = daocon.readConseillerDaoById(1L);
		System.out.println(con);
	}

}
