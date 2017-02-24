package classes;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	
	@Column
	private String author;
	
	@OneToMany(mappedBy = "prefere")
	private List<Client> client;
	
	@ManyToMany(mappedBy = "achats")
	private List<Client> acheteurs;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public List<Client> getClient() {
		return client;
	}


	public void setClient(List<Client> client) {
		this.client = client;
	}


	public List<Client> getAcheteurs() {
		return acheteurs;
	}


	public void setAcheteurs(List<Client> acheteurs) {
		this.acheteurs = acheteurs;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
		
}
