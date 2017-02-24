

import javax.persistence.EntityManager;

import dao.DatabaseHelper;

public class Run {

	public static void main(String[] args) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Book b1 = new Book();
		b1.setTitle("Le petit cheval de manège");
		b1.setAuthor("Just Leblanc");
		
		Client c1 = new Client();
		c1.setLastName("Bricas");
		c1.setFirstName("Samuel");
		c1.setGender(Gender.M);
		
		c1.achete(b1);
		
		em.persist(b1);
		em.persist(c1);
		
		DatabaseHelper.commitTxAndClose(em);
		
		
	}

}
