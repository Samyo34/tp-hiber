package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.Book;


public class QueryManager {

	
	public static List<Book> getBooks(EntityManager em)
	{
		TypedQuery<Book> query = em.createQuery("select b "+
				"from Book b "+
				"inner join b.acheteurs",Book.class);
		List<Book> clients = query.getResultList();
		return clients;
	}
}
