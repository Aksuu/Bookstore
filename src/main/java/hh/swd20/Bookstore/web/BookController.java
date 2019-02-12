package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository repository;
	
	@GetMapping("/booklist")
	public String bookStore(Model model) {
		model.addAttribute("books", repository.findAll());
		return "Bookstore";
	}
	
}
