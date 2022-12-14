package bookstore.io.github.lhsaga.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.io.github.lhsaga.bookstore.model.Book;
import bookstore.io.github.lhsaga.bookstore.model.BookRepository;
import bookstore.io.github.lhsaga.bookstore.model.Category;
import bookstore.io.github.lhsaga.bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository,CategoryRepository crepository) {
		return (args) -> {
			log.info("some book info");
			crepository.save(new Category("Erotic Novel"));
			crepository.save(new Category("Computing"));
			crepository.save(new Category("Health"));
			repository.save(new Book("Rode Hard, Put Up Wet", " Lorelei James", 2007,"9781599988368", 21.33,crepository.findByName("Computing").get(0)));
			repository.save(new Book("Two in the Bush", "Gerald Durrell", 1966, "9780006345541", 18.99,crepository.findByName("Erotic Novel").get(0)));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
