package project.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	// peritään findAll(), findById(), save(), deleteById()
}
