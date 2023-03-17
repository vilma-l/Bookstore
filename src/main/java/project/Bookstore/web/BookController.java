package project.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.Bookstore.domain.Book;
import project.Bookstore.domain.BookRepository;
import project.Bookstore.domain.Category;
import project.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//lähettää selaimeen etusivunäkymän html-dokumentin
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex() {
		
		return "bookstore"; //bookstore.html
	}
	
	//kirjalistaus
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
		
		List<Book> books = (List<Book>) bookRepository.findAll(); // haetaan tietokannasta
		model.addAttribute("books", books); //välitetään lista kirjoista templatelle
		
		return "booklist"; //booklist.html
	}
	
	//kaikki kirjat JSON-muodossa, REST
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBooks() {
		return (List<Book>) bookRepository.findAll();
	}
	
	//yksi kirja id-arvolla, REST
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> getOneBook(@PathVariable("id") Long bookId) {
		return bookRepository.findById(bookId);
	}
	
	// tyhjä kirjalomake
	
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
	public String getAddBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "addbook"; //addbook.html
	}
	
	// lomakkeella syötettyjen tietojen vastaanotto ja tallennus
	
	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book, Model model) {
		bookRepository.save(book); // tallennetaan uusi kirja tietokantaan, jos id-arvo on 0 tai null
		
		return "redirect:/booklist";
	}
	
	// kirjan poisto
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		
		return "redirect:/booklist";
	}
	
	// kirjan muokkaus
	
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		//Book bookToEdit = bookRepository.findById(id).get();
		//model.addAttribute("book", bookToEdit);
		model.addAttribute("book", bookRepository.findById(id));
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "editbook";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		
		return "redirect:/booklist";
	}
}
