package kr.co.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.kopo.model.Users;
import kr.co.kopo.service.UsersService;


@Controller
@RequestMapping("/users")
public class UsersController {
	final static String path = "users/"; // 중복되는 부분을 패스를 설정해두고 사용
	
	@Autowired
	UsersService service;

	@GetMapping("/list")
	String getUsers(Model model, @SessionAttribute("users") Users user) {
		List<Users> userList = service.getUsers();
		model.addAttribute("userList",userList);
		return path + "list";
	}
	
	@GetMapping("/update/{id}")
	String updateUser(@PathVariable String id, Model model) {
		
		Users user = service.getUser(id);
		model.addAttribute("user", user);
		
		return path + "update";
	}
	
	@PostMapping("/update/{id}")
	String updateUser(Users user) {
		service.updateUser(user);
		
		return "redirect:../list";	//pathvariable을 사용했기 때문에 주소가 하나 더 안쪽에 있어서 하나 빠져나와야함. 그래서 ..을 사용해서 pathvariable을 빠져나와줌.
	}
	
	
	@GetMapping("/delete/{id}")
	String deleteUser(@PathVariable String id) {
		service.deleteUser(id);
		
		return "redirect:../list";
	}
	
	//회원 가입 부분은 users를 거치지 않게 RootController로 이동시킴
}
