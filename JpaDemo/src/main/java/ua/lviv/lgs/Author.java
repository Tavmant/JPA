package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Author.findByName", query = "SELECT a FROM Author a WHERE a.name = :name") })
public class Author extends BasicEntity {
	@Column
	private String name;
	@Column
	private int age;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
	private List<Book> books;

	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		if (books == null) {
			books = new ArrayList<Book>();
		}
		books.add(book);
		book.setAuthor(this);
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + getId() + ", name=" + name + ", age=" + age + "]";
	}

}
