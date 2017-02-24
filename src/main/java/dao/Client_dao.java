package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.Book;
import classes.Client;

public class Client_dao {
	
	/**
	 * Ajoute un Client dans la base de de donn�es
	 * 
	 * @param Client
	 */
	public static void createClient(Client client){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(client);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	/**
	 * Ajoute une liste de Client � la base de donn�es
	 * 
	 * @param Clients
	 */
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
	
	/**
	 * Met � jour les donn�es du Client pass� en param�tre
	 * 
	 * @param Client
	 */
	public static void updateClient(Client client){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(client);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	/**
	 * Met � jour les donn�es d'une liste de Client pass�e en param�tre
	 * 
	 * @param Client
	 */
	public static void updateClients(List<Client> clients){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (Client client : clients) {
			em.merge(client);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
	/**
	 * Retourne la liste de tout les Client pr�sent dans la base de donn�es
	 * 
	 * @return List<Client>
	 */
	public static List<Client> getAllClient(){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Client> query = em.createQuery("select c "+
				"from Client c ",Client.class);
		List<Client> clients = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return clients;
	}
	
	/**
	 * Retourne un Client en fonction de son identifiant
	 * 
	 * @param idClient
	 * @return Client
	 */
	public static Client getClientById(Long idClient){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Client client = em.find(Client.class,idClient);
		DatabaseHelper.commitTxAndClose(em);
		return client;
	}
	
	/**
	 * Retourne un Client en fonction de son nom et pr�nom
	 * remarque : homonyme interdit (pas de tests, prenez garde !)
	 * 
	 * @param firstName
	 * @return Client
	 */
	public static Client getClientByFirstAndLastName(String firstName, String lastName){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Client> query = em.createQuery("select c "+
				"from Client c "+
				"where c.firstName =:firstName and "+
				"c.lastName =:lastName ",Client.class);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		Client client = query.getSingleResult();
		DatabaseHelper.commitTxAndClose(em);
		return client;
	}
	
	
	public static void prefere(Client client, Book book){
		client.setPrefere(book);
		updateClient(client);
	}
	/**
	 * Retourne la liste des Client qui ont achet� le livre pass�
	 * en param�tre
	 * 
	 * @param Book
	 * @return List<Client>
	 */
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
