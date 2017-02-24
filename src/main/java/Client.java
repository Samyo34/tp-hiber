import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="client")
public class Client {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String lastName;
	
	@Column
	private String firstName;
	
	@Column
	private Gender gender;
	
	@ManyToOne
	private Book prefere;
	
	@ManyToMany
	private List<Book> achats = new ArrayList<Book>();

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

	public List<Book> getAchat() {
		return achats;
	}

	public void setAchat(List<Book> achat) {
		this.achats = achat;
	}

	public List<Book> getAchats() {
		return achats;
	}

	public void setAchats(List<Book> achats) {
		this.achats = achats;
	}
	
	public void achete(Book book)
	{
		this.achats.add(book);
	}
	
	
	
}
