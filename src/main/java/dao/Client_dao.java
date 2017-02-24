package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.Book;
import classes.Client;

public class Client_dao {
	
	public static void createClient(Client client){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(client);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static void createClients(List<Client> clients){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (Client client : clients) {
			em.persist(client);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static void deleteClient(Client client){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(client);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static void deleteClients(List<Client> clients){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (Client client : clients) {
			em.remove(client);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static void updateClient(Client client){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(client);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static void updateClients(List<Client> clients){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (Client client : clients) {
			em.merge(client);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static List<Client> getAllClient(){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Client> query = em.createQuery("select c "+
				"from Client c ",Client.class);
		List<Client> clients = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return clients;
	}
	
	public static Client getClientById(Long idClient){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Client client = em.find(Client.class,idClient);
		DatabaseHelper.commitTxAndClose(em);
		return client;
	}
	
	public static Client getClientByFirstName(String firstName){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Client> query = em.createQuery("select c "+
				"from Client c "+
				"where c.firstName =:firstName",Client.class);
		query.setParameter("id", firstName);
		Client client = query.getSingleResult();
		DatabaseHelper.commitTxAndClose(em);
		return client;
	}
	
	public static Client getClientByLastName(String lastName){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Client> query = em.createQuery("select c "+
				"from Client c "+
				"where c.lastName =:firstName",Client.class);
		query.setParameter("id", lastName);
		Client client = query.getSingleResult();
		DatabaseHelper.commitTxAndClose(em);
		return client;
	}
	
	public static void prefere(Client client, Book book){
		client.setPrefere(book);
		updateClient(client);
	}
	
	public static List<Client> getAcheteurs(Book book){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Client> query = em.createQuery("select c "+
				"from Client c "+
				"inner join c.achats a "+
				"where a.id =:id",Client.class);
		query.setParameter("id", book.getId());
		List<Client> clients = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return clients;
	}
}
