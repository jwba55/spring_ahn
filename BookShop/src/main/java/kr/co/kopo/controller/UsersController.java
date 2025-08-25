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
	String getUsers(Model model, @SessionAttribute("user") Users user) {
		List<Users> users = service.getUsers();
		model.addAttribute("users",users);
		return path + "list";
	}
	
	@GetMapping("/add")
	String addUser() {
		
		return path + "add";
	}
	
	@PostMapping("/add")
	String addUser(Users user) {
		service.addUser(user);
		
		return "redirect:list";
		//redirect란?
			//request가 왔을때 처리 후 다시 표시할 페이지로 request를 새로 만들어서 리스트 주소로 보내줌.
			//request가 두번 왔다갔다함.
		
		//foward
			//위에 있는 리스트로 보내면 디비에서 목록을 읽어서 다시 리스트로 보내줌
			//문제가 생김
				//실제 주소가 이전 주소에 머물러 있기 때문에 새로고침시 다시 post 되면서 같은 정보가 여러번 등록되는 문제가 생길수있음.
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
	
}
