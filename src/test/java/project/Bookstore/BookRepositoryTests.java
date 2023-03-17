package project.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.Bookstore.domain.Book;
import project.Bookstore.domain.BookRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test //testataan BookRepositoryn findByTitle()-metodin toimivuutta
	public void findByTitleShouldReturnBook() {
		List<Book> books = bookRepository.findByTitle("Nalle Puh");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("A.A. Milne");
	}
	
	@Test //testataan BookRepositoryn save()-metodin toimivuutta
	public void createNewBook() {
		Book book = new Book("Testikirja", "Testi Testinen", 2023, "11-22-33", 20.00, null);
		bookRepository.save(book);
		
		assertThat(book.getId()).isNotNull();
	}
	
	@Test //testataan BookRepositoryn delete()-metodin toimivuutta
	public void deleteBook() {
		Book book = bookRepository.findById(1L).get();
		bookRepository.delete(book);
		
		Book book1 = null;
		
		Optional<Book> optionalBook = bookRepository.findByYear(1926);
		
		if(optionalBook.isPresent()) {
			book1 = optionalBook.get();
		}
		
		assertThat(book1).isNull();
	}

}
