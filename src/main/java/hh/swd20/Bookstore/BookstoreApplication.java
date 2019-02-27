package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner BookstoreDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("A few books");
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Fiction"));
			
			repository.save(new Book("Prince of Fools", "Mark Lawrence", "978-0-00-753156-1", 2015, 8.99, crepository.findByName("Fiction").get(0)));
			repository.save(new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", "978-951-31-1737-5", 1999, 19.99, crepository.findByName("Fantasy").get(0)));	
			
			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}

