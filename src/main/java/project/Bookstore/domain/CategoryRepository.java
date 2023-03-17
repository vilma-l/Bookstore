package project.Bookstore.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	// peritään findAll(), findById(), save(), deleteById()
	
	List<Category> findByName(String name);
	Optional<Category> findById(Long categoryId);
}
