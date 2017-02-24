package classes;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String lastName;
	
	@Column
	private String firstName;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Gender gender;
	
	@ManyToOne
	private Book prefere;
	
	@ManyToMany
	private Set<Book> achats = new HashSet<Book>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Book getPrefere() {
		return prefere;
	}

	public void setPrefere(Book prefere) {
		this.prefere = prefere;
	}

	public Set<Book> getAchats() {
		return achats;
	}

	public void setAchats(Set<Book> achats) {
		this.achats = achats;
	}
	
	public void achete(Book book)
	{
		this.achats.add(book);
	}
	
	public void prefere(Book book)
	{
		this.prefere = book;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", gender=" + gender
				+ ", prefere=" + prefere + "]";
	}
	

	
	
}
