package project.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.Bookstore.domain.User;
import project.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test //testataan UserRepositoryn findByRole() - metodin toimivuutta
	public void findByRoleShouldReturnUser() {
		List<User> users = userRepository.findByRole("ADMIN");
		
		assertThat(users).hasSize(1);
		assertThat(users.get(0).getEmail()).isEqualTo("admin@user.com");
	}
	
	@Test //testataan UserRepositoryn save() - metodin toimivuutta
	public void createNewUser() {
		User user = new User("testuser", "$2a$10$rg6U5x8S4ktM18o2vALDJOUDuzi0Xt5OAVjOvaE3wy0ctKnAZfIA2", "test@user.com", "USER");
		userRepository.save(user);
		
		assertThat(user.getId()).isNotNull();
	}
	
	@Test //testataan UserRepositoryn delete() - metodin toimivuutta
	public void deleteUser() {
		User user = userRepository.findById(1L).get();
		userRepository.delete(user);
		
		User user1 = null;
		
		Optional<User> optionalUser = userRepository.findById(1L);
		
		if(optionalUser.isPresent()) {
			user1 = optionalUser.get();
		}
		
		assertThat(user1).isNull();
	}

}
