package hh.swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/booklist")
	public String bookStore(Model model) {
		model.addAttribute("books", repository.findAll());
		return "Bookstore";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
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
	
	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	@GetMapping("/book/{id}")
	public @ResponseBody Optional<Book> findBookRes(@PathVariable("id") Long bookId){
		return repository.findById(bookId);
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
}
