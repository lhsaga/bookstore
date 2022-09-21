package bookstore.io.github.lhsaga.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import bookstore.io.github.lhsaga.bookstore.model.Book;
import bookstore.io.github.lhsaga.bookstore.model.BookRepository;
import bookstore.io.github.lhsaga.bookstore.model.CategoryRepository;

@Controller

public class BookController {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value= {"/","/bookList"})
	public String bookList(Model model) {
		model.addAttribute("books",repository.findAll());
		return "bookList";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book",new Book());
		model.addAttribute("books", crepository.findAll());
		return "addBook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:bookList";
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../bookList";
	}

}
