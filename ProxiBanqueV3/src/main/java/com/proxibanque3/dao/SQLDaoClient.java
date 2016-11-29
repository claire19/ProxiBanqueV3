package com.proxibanque3.dao;

import java.util.ArrayList;
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

public class SQLDaoClient implements DaoClient {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");

	@Override
	public void createClientDao(Client client) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();

		try {
			tnx.begin();
			em.persist(client);

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
	public Map<Long, Client> readAllClientDao() {

		Map<Long, Client> allClients = new HashMap<>();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		List<?> retList = new ArrayList<>();

		try {
			tnx.begin();

			// Query query = em.createQuery("from Person where TypePerson =
			// Client", Person.class);
			Query query = em.createQuery("from Client", Client.class);

			retList = query.getResultList();

			for (Iterator<?> i = retList.iterator(); i.hasNext();) {
				Client c = (Client) i.next();
				long id = c.getId();

				allClients.put(id, c);

			}

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
		return allClients;
	}

	@Override
	public Client readClientDaoById(int idClient) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		Client c = new Client();

		try {
			tnx.begin();

			c = em.find(Client.class, idClient);

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
		if (c != null) {
			return c;
		} else {
			System.out.println("pas de conseiller correspondant à cet ID");
			return null;
		}

	}

	@Override
	public void updateClientDao(Client client) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();

		try {
			tnx.begin();

			// Client c = em.find(Client.class, client.getId());

			em.merge(client);

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
	public void deleteClientDao(Client client) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		if (client != null) {
			try {
				tnx.begin();

				em.remove(em.find(Client.class, client.getId()));

				tnx.begin();
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
			System.out.println("ce conseiller n'existe pas dans la DB il ne peut donc etre supprimé");
		}
	}

}
