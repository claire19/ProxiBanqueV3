package com.proxibanque3.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.proxibanque3.model.Client;
import com.proxibanque3.model.Compte;

public class SQLDaoCompte implements DaoCompte {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public void createCompteDao(Compte compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		try {
			tnx.begin();
			em.persist(compte);
			tnx.commit();
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Map<Long, Compte> readAllCompteDao() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		Map<Long, Compte> allComptes = new HashMap<>();

		try {
			tnx.begin();
			Query q = em.createQuery("from Compte", Compte.class);
			List<?> retList = q.getResultList();
			for (Iterator<?> i = retList.iterator(); i.hasNext();) {
				Compte c = (Compte) i.next();
				allComptes.put(c.getNumeroCompte(), c);
			}

			tnx.commit();
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return allComptes;
	}

	@Override
	public Compte readCompteDaoById(long numeroCompte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Compte compte = null;
		try {
			txn.begin();
			compte = em.find(Compte.class, numeroCompte);
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return compte;
	}

	@Override
	public void updateCompteDao(Compte compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();

		try {
			tnx.begin();

			em.merge(compte);

			tnx.commit();
		} catch (Exception e) {
			if (tnx != null) {
				tnx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void deleteCompteDao(Compte compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		if (compte != null) {
			try {
				tnx.begin();

				em.remove(em.find(Compte.class,compte.getNumeroCompte()));

				tnx.commit();
			} catch (Exception e) {
				if (tnx != null) {
					tnx.rollback();
				}
				e.printStackTrace();
			} finally {
				if (em != null) {
					em.close();
				}
			}
		} else {
			System.out.println("ce compte n'existe pas dans la DB il ne peut donc etre supprimé");
		}

	}
}
