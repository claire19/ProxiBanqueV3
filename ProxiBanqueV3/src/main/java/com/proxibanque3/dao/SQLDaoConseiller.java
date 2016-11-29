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

import com.proxibanque3.model.Conseiller;

public class SQLDaoConseiller implements DaoConseiller {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public void createConseillerDao(Conseiller conseiller) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		try {
			tnx.begin();
			em.persist(conseiller);
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
		System.exit(0);
	}

	@Override
	public Map<Long, Conseiller> readAllConseillerDao() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		Map<Long, Conseiller> allConseillers = new HashMap<>();

		try {
			tnx.begin();
			Query q = em.createQuery("from Conseiller", Conseiller.class);
			List<?> retList = q.getResultList();
			for (Iterator<?> i = retList.iterator(); i.hasNext();) {
				Conseiller c = (Conseiller) i.next();
				allConseillers.put(c.getId(), c);

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
		System.exit(0);
		return allConseillers;
	}

	@Override
	public Conseiller readConseillerDaoById(long idConseiller) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		Conseiller conseiller = new Conseiller();
		try {
			txn.begin();
			// faire une concatenation plus propre
//			String requete = "from Person where TypePersonne = Conseiller and id = " + idConseiller;
//			System.out.println(requete);
//			Query q = em.createQuery(requete, Person.class);
			conseiller = em.find(Conseiller.class, idConseiller);
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
		System.exit(0);
		if (conseiller != null) {
			return conseiller;
		} else {
			System.out.println("pas de conseiller correspondant à cet ID");
			return null;
		}
	}

	@Override
	public void updateConseillerDao(Conseiller conseiller) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();

		try {
			tnx.begin();

			em.merge(conseiller);

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
		System.exit(0);
	}

	@Override
	public void deleteConseillerDao(Conseiller conseiller) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		if (conseiller != null) {
			try {
				tnx.begin();

				em.remove(em.find(Conseiller.class, conseiller.getId()));

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
			System.exit(0);
		} else {
			System.out.println("ce conseiller n'existe pas dans la DB il ne peut donc etre supprimé");
		}

	}

}
