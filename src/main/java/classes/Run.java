package classes;


import javax.persistence.EntityManager;

import dao.Book_dao;
import dao.Client_dao;
import dao.DatabaseHelper;
import dao.QueryManager;

public class Run {

	public static void main(String[] args) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Book b1 = new Book();
		b1.setTitle("Le petit cheval de manège");
		b1.setAuthor("Just Leblanc");
		
		Book b2 = new Book();
		b2.setTitle("Un livre");
		b2.setAuthor("Auteur");
		
		Book b3 = new Book();
		b3.setTitle("Un autre livre");
		b3.setAuthor("autre Auteur");
		
		Client c1 = new Client();
		c1.setLastName("Bricas");
		c1.setFirstName("Samuel");
		c1.setGender(Gender.M);
		
		Client c2 = new Client();
		c2.setLastName("Leguerec");
		c2.setFirstName("Christine");
		c2.setGender(Gender.F);
		
		Book_dao.createBook(b1);
		Book_dao.createBook(b2);
		Book_dao.createBook(b3);
		
		Client_dao.createClient(c1);
		Client_dao.createClient(c2);
		
		c1.achete(b1);
		c2.achete(b2);
		
		c1.prefere(b1);
		c2.prefere(b3);
		
		Client_dao.updateClient(c1);
		Client_dao.updateClient(c2);
		
		for (Client client : Client_dao.getAcheteurs(b1)) {
			System.out.println(client);
		}
		
		for (Book book : Book_dao.getBookAchete(c1)) {
			System.out.println(book);
		}
		
		for (Book book : Book_dao.getBooksAchete()) {
			System.out.println(book);
		}
		
		
	}

}
