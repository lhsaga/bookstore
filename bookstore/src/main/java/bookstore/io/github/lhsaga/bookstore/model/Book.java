package bookstore.io.github.lhsaga.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private int myYear;
	private String isbn;
	private double price;
	
	@ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
	public Book() {
	}


	
	public Book(String title, String author, int myYear, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.myYear = myYear;
		this.isbn = isbn;
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



	public int getMyYear() {
		return myYear;
	}




	public void setMyYear(int myYear) {
		this.myYear = myYear;
	}




	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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
		if(this.category != null)
		return "Book [title=" + title + ", author=" + author + ", myYear=" + myYear + ", isbn=" + isbn + ", price="
				+ price + ", category=" + this.getCategory() + "]";
		else
		return "Book [title=" + title + ", author=" + author + ", myYear=" + myYear + ", isbn=" + isbn + ", price="
		+ price + "]";
	}

	
}
