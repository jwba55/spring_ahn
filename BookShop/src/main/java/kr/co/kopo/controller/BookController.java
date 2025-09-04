package kr.co.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.kopo.model.Book;
import kr.co.kopo.model.Users;
import kr.co.kopo.pager.Pager;
import kr.co.kopo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	final static String path = "book/";
	
	@Autowired
	BookService bookService;
	
//	@GetMapping("/list")
//	String list(Model model, @SessionAttribute("users") Users users) {	//@SessionAttribute를 사용하면 로그인하지 않은 사람의 접근을 차단할 수 있음.
//		List<Book> book = bookService.list();
//		model.addAttribute("book", book);
//		
//		
//		return path + "list";
//	}
	
	@GetMapping("/dummy")
	String dummy() {
		bookService.dummy();
		
		return "redirect:list";
	}
	
	@GetMapping("/init")
	String init() {
		bookService.init();
		
		return "redirect:list";
	}
	
	@GetMapping("/list")
	String list(Pager pager, Model model) {
		List<Book> list =  bookService.getBookList(pager);
		
		model.addAttribute("bookList",list);
		model.addAttribute("pager",pager);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	String addUser() {
		
		return path + "add";
	}
	
	@PostMapping("/add")
	String addUser(Book book) {
		bookService.addBook(book);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{bookId}")
	String updateBook(@PathVariable int bookId, Model model) {
		
		Book book = bookService.getBook(bookId);
		model.addAttribute("book", book);
		
		return path + "update";
	}
	
	@PostMapping("/update")
	String updateBook(Book book) {
		bookService.updateBook(book);
		
		return "redirect:list";
	}
	
	
	
	@GetMapping("/delete/{bookId}")
	String deleteBook(@PathVariable int bookId) {
		bookService.deleteBook(bookId);
		
		return "redirect:../list";
	}

}
