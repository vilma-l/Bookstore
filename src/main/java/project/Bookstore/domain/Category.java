package project.Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	//attribuutit
	@Id //pääavainsarake
	@GeneratedValue(strategy = GenerationType.AUTO) //automaattisesti generoituva id-arvo
	private Long categoryid;
	private String name;
	
	//konstruktorit
	public Category() {
		super();
		this.categoryid = null;
		this.name = null;
	}
	
	public Category(String name) {
		super();
		this.categoryid = null;
		this.name = name;
	}
	
	public Category(Long categoryid, String name) {
		super();
		this.categoryid = categoryid;
		this.name = name;
	}
	
	//getterit & setterit
	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//toString
	@Override
	public String toString() {
		return "categoryid= " + categoryid + ", name= " + name;
	}
	
}
