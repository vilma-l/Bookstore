package project.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	// peritään findAll(), findById(), save(), deleteById()
}
