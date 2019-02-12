package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.Bookstore.domain.Book;
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
	
	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }
	
	//Check ‘Add book’-functionality from the controller. In add functionality you added new book object to model but now you will
	// add current book object to model. You also have to send current book id from the list page to controller (like you did in delete link).
	
	@GetMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") Long editId, Model model) {
		model.addAttribute("book", repository.findById(editId));
		return "editbook";
	}
	
}
