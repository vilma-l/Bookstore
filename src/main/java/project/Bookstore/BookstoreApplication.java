package project.Bookstore;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.Bookstore.domain.Book;
import project.Bookstore.domain.BookRepository;
import project.Bookstore.domain.Category;
import project.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (arg) -> {
			Book book1 = new Book("Nalle Puh", "A.A. Milne", 1926, "951-0-07753-4", 15.00);
			Book book2 = new Book("Nalle Puh rakentaa talon", "A.A. Milne", 1928, "951-0-08182-5", 15.00);
			bookRepository.save(book1);
			bookRepository.save(book2);
			
			Category category1 = new Category("Children's books");
			Category category2 = new Category("Romance");
			Category category3 = new Category("Science");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			
			//haetaan tiedot tietokannasta
			
			List<Book> books = (List<Book>) bookRepository.findAll();
			for (Book book : books) {
				System.out.println(book.toString());
			}
			
			List<Category> categories = (List<Category>) categoryRepository.findAll();
			for (Category category : categories) {
				System.out.println(category.toString());
			}
		};
	}

}
