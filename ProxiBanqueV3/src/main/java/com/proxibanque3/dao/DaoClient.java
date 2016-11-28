package com.proxibanque3.dao;

import java.util.Map;

import com.proxibanque3.model.Client;

public interface DaoClient {

	void createClientDao(Client client);

	Map<Long, Client> readAllClientDao();

	Client readClientDaoById(int idClient);

	void updateClientDao(Client client);

	void deleteClientDao(Client client);

}
