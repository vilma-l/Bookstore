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
import project.Bookstore.domain.User;
import project.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (arg) -> {
			log.info("Saving a few books and their categories");
			
			Category category1 = new Category("Children's books");
			categoryRepository.save(category1);
			Category category2 = new Category("Romance");
			categoryRepository.save(category2);
			Category category3 = new Category("Science");
			categoryRepository.save(category3);
			
			bookRepository.save(new Book("Nalle Puh", "A.A. Milne", 1926, "951-0-07753-4", 15.00, categoryRepository.findByName("Children's books").get(0)));
			bookRepository.save(new Book("Nalle Puh rakentaa talon", "A.A. Milne", 1928, "951-0-08182-5", 15.00, categoryRepository.findByName("Children's books").get(0)));
			
			//luodaan käyttäjät: admin/admin ja user/user
			
			User user1 = new User("admin", "$2a$10$cDdHNKd7alO4g35pWRxxB.p6MV5nhdH9Ux2XjE4/2Y1TidSxcUjHW", "admin@user.com", "ADMIN");
			User user2 = new User("user", "$2a$10$W9gRhLFRPwc6lJAJskSVb.CxgVLr3pI8f9dVIAQ4fo.xgiK0.3em.", "user@user.com", "USER");
			userRepository.save(user1);
			userRepository.save(user2);
			
			//haetaan tiedot tietokannasta
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
