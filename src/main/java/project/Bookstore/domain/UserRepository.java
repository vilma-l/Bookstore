package project.Bookstore.domain;

import java.util.Optional;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username); //sisäänkirjautumistestiä varten
	List<User> findByRole(String role);
	Optional<User> findById(Long id);
}
