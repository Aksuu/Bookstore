package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title, author, isbn;
	private int year;
	private Double price;
	
	@JsonIgnore
	@ManyToOne // Student ManyToOne Department
    @JoinColumn(name = "categoryId") // Foreign Key-määritys tietokantataulua varten
    private Category category;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String isbn, int year, Double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year + ", price=" + price + " category =" + this.getCategory() + "]";
		else
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
				+ ", price=" + price + "]";
	}

	

}
