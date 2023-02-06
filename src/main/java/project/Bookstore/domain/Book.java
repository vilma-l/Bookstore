package project.Bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
	
	//konstruktorit
	public Book() {
		super();
		this.id = null;
		this.title = null;
		this.author = null;
		this.year = 0;
		this.isbn = null;
		this.price = 0.00;
	}
	
	public Book(String title, String author, int year, String isbn, double price) {
		super();
		this.id = null;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Book(Long id, String title, String author, int year, String isbn, double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
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
	
	//toString
	@Override
	public String toString() {
		return "id= " + id + ", title= " + title + ", author= " + author + ", year= " + year + ", isbn= " + isbn + ", price= " + price;
	}
}
