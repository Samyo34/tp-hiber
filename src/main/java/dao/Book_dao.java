package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.Book;
import classes.Client;

public class Book_dao {
	
	/**
	 *  Ajoute un Book dans la base de de donn�es
	 * 
	 * @param Book
	 */
	public static void createBook(Book book){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(book);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	/**
	 *  Ajoute une liste de Book dans la base de de donn�es
	 * 
	 * @param List<Book>
	 */
	public static void createBooks(List<Book> books){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (Book book : books) {
			em.persist(book);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static void deleteBook(Book book){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.remove(book);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public static void deleteBooks(List<Book> books){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (Book book : books) {
			em.remove(book);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
	/**
	 * Met � jour les donn�es du Book pass� en param�tre
	 * 
	 * @param Book
	 */
	public static void updateBook(Book book){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.merge(book);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	/**
	 * Met � jour les donn�es d'une liste de Book pass�e en param�tre
	 * 
	 * @param List<Book>
	 */
	public static void updateClients(List<Book> books){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		for (Book book : books) {
			em.merge(book);
		}
		DatabaseHelper.commitTxAndClose(em);
	}
	
	/**
	 * Retourne la liste de tout les Book pr�sent dans la base de donn�es
	 * 
	 * @return List<Book>
	 */
	public static List<Book> getAllBooks(){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Book> query = em.createQuery("select b "+
				"from Book b ",Book.class);
		List<Book> books = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return books;
	}
	
	/**
	 * Retourne un Book en fonction de son identifiant
	 * 
	 * @param idBook
	 * @return Book
	 */
	public static Book getBookById(Long idBook){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Book book = em.find(Book.class,idBook);
		DatabaseHelper.commitTxAndClose(em);
		return book;
	}
	
	/**
	 * Retourne un Book en fonction de son titre
	 * 
	 * @param titleBook
	 * @return Book
	 */
	public static Book getBookByTitle(Long titleBook){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Book> query = em.createQuery("select b "+
				"from Book b "+
				"where b.title =:title",Book.class);
		query.setParameter("id", titleBook);
		Book book = query.getSingleResult();
		DatabaseHelper.commitTxAndClose(em);
		return book;
	}
	
	/**
	 * Retourne la liste des Book achet� par le client pass� en param�tre
	 * 
	 * @param Client
	 * @return List<Book>
	 */
	public static List<Book> getBookAchete(Client client){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Book> query = em.createQuery("select b "+
				"from Book b "+
				"inner join b.acheteurs a "+
				"where a.id =:id",Book.class);
		query.setParameter("id", client.getId());
		List<Book> books = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return books;
	}
	
	/**
	 * Retourne la liste des Book qui ont �t� achet�
	 * 
	 * @return List<Book>
	 */
	public static List<Book> getBooksAchete(){
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Book> query = em.createQuery("select b "+
				"from Book b "+
				"inner join b.acheteurs a ",Book.class);
		List<Book> books = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return books;
	}
}
