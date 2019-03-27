package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {

	
	@Autowired
	private BookRepository bookRepository;
	private CategoryRepository categoryRepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("Prince of Fools");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Mark Lawrence");
    }
	
	@Test
	public void findByNameShouldReturnCategory() {
        List<Category> categories = categoryRepository.findByName("Fantasy");
        
        assertThat(categories).hasSize(1);
//        assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
    }
	
	@Test
    public void createNewBook() {
    	Book book = new Book("Title", "Author", "isbn-001", 2000, 9.99, new Category("Mystery"));
    	bookRepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
}
