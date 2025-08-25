package kr.co.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.kopo.model.Book;
import kr.co.kopo.model.Users;
import kr.co.kopo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	final static String path = "book/";
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/list")
	String list(Model model, @SessionAttribute("users") Users users) {	//@SessionAttribute를 사용하면 로그인하지 않은 사람의 접근을 차단할 수 있음.
		List<Book> book = bookService.list();
		model.addAttribute("book", book);
		
		
		return path + "list";
	}

}
