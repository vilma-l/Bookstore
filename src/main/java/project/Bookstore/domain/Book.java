package project.Bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	
	//attribuutit
	@Id //pääavainsarake
	@GeneratedValue(strategy = GenerationType.AUTO) //automaattisesti generoituva id-arvo
	private Long id;
	private String title;
	private String author;
	@Column(name = "publishing_year")
	private int year;
	private String isbn;
	private double price;
	
	@ManyToOne() // yhteys kategoria-luokkaan
	@JoinColumn(name = "categoryid") // viiteavain
	private Category category;
	
	//konstruktorit
	public Book() {
		super();
		this.id = null;
		this.title = null;
		this.author = null;
		this.year = 0;
		this.isbn = null;
		this.price = 0.00;
		this.category = null;
	}
	
	public Book(String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.id = null;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public Book(Long id, String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	//getterit & setterit
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//toString
	@Override
	public String toString() {
		if (this.category != null)
			return "id= " + id + ", title= " + title + ", author= " + author + ", year= " + year + ", isbn= " + isbn + ", price= " + price + ", category= " + category;
		else
			return "id= " + id + ", title= " + title + ", author= " + author + ", year= " + year + ", isbn= " + isbn + ", price= " + price;
	}
}
