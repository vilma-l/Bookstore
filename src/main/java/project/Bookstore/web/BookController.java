package project.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.Bookstore.domain.Book;
import project.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
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
	
	// tyhjä kirjalomake
	
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
	public String getAddBookForm(Model model) {
		model.addAttribute("book", new Book());
		
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
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepository.deleteById(id);
		
		return "redirect:/booklist";
	}
	
	// kirjan muokkaus
	
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book bookToEdit = bookRepository.findById(id).get();
		model.addAttribute("book", bookToEdit);
		
		return "editbook";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		
		return "redirect:/booklist";
	}
}
