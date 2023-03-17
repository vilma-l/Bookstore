package project.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.Bookstore.domain.Category;
import project.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test //testataan CategoryRepositoryn findByName() - metodin toimivuutta
	public void findByNameShouldReturnCategory() {
		List<Category> categories = categoryRepository.findByName("Children's books");
		
		assertThat(categories).hasSize(1);
	}
	
	@Test //testataan CategoryRepositoryn save() - metodin toimivuutta
	public void createNewCategory() {
		Category category = new Category("Science Fiction");
		categoryRepository.save(category);
		
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test //testataan CategoryRepositoryn delete() - metodin toimivuutta
	public void deleteCategory() {
		Category category = categoryRepository.findById(1L).get();
		categoryRepository.delete(category);
		
		Category categoryTest = null;
		
		Optional<Category> optionalCategory = categoryRepository.findById(1L);
		
		if(optionalCategory.isPresent()) {
			categoryTest = optionalCategory.get();
		}
		
		assertThat(categoryTest).isNull();
	}

}