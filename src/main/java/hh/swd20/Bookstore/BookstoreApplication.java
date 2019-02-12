package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner BookstoreDemo(BookRepository repository) {
		return (args) -> {
			log.info("A few books");
			repository.save(new Book("Prince of Fools", "Mark Lawrence", "isbn 978-0-00-753156-1", 2015, 8.99));
			repository.save(new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", "isbn-13: 978-951-31-1737-5", 1999, 19.99));	
			
			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}

