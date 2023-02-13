package project.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (arg) -> {
			log.info("Saving a few books and their categories");
			
			Category category1 = new Category("Children's books");
			categoryRepository.save(category1);
			Category category2 = new Category("Romance");
			categoryRepository.save(category2);
			Category category3 = new Category("Science");
			categoryRepository.save(category3);
			
			bookRepository.save(new Book("Nalle Puh", "A.A. Milne", 1926, "951-0-07753-4", 15.00, category1));
			bookRepository.save(new Book("Nalle Puh rakentaa talon", "A.A. Milne", 1928, "951-0-08182-5", 15.00, category1));
			
			//haetaan tiedot tietokannasta
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
