package project.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.Bookstore.web.BookController;
import project.Bookstore.web.CategoryController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;
	
	@Autowired
	private CategoryController categoryController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
	}

}
