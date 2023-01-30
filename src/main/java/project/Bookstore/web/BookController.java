package project.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	
	//lähettää selaimeen etusivunäkymän html-dokumentin
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex() {
		
		return "bookstore"; //bookstore.html
	}

}
