package project.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
