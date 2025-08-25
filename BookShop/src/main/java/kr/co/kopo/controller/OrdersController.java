package kr.co.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.kopo.model.Book;
import kr.co.kopo.model.Orders;
import kr.co.kopo.model.Users;
import kr.co.kopo.service.BookService;
import kr.co.kopo.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	final static String path = "orders/";
	
	@Autowired
	OrdersService ordersService;
	
	@GetMapping("/list")
	String list(Model model, @SessionAttribute("users") Users users) {
		List<Orders> orders = ordersService.list();
		model.addAttribute("orders", orders);
		
		return path + "list";
	}

}
