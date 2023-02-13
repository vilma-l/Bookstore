package project.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.Bookstore.domain.Category;
import project.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	// kategorialistaus
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategories(Model model) {
		
		List<Category> categories = (List<Category>) categoryRepository.findAll(); // haetaan tietokannasta
		model.addAttribute("categories", categories); //välitetään lista kategorioista templatelle
		
		return "categorylist"; //categorylist.html
	}
	
	// tyhjä lisäyslomake
	
	@RequestMapping(value = "/newcategory", method = RequestMethod.GET)
	public String getAddCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		
		return "addcategory"; //addcategory.html
	}
	
	// lomakkeella syötettyjen tietojen vastaanotto ja tallennus
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category, Model model) {
		categoryRepository.save(category); // tallennetaan uusi kategoria tietokantaan, jos id-arvo on 0 tai null
		
		return "redirect:/categorylist";
	}

}
