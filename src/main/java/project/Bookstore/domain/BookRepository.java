package project.Bookstore.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	// peritään findAll(), findById(), save(), deleteById()
	
	List<Book> findByTitle(String title);
	Optional<Book> findByYear(int year);
}
