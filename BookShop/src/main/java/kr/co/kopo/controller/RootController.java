package kr.co.kopo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kopo.model.Users;
import kr.co.kopo.service.UsersService;

@Controller
public class RootController {
	
	@Autowired
	UsersService usersService;

	@GetMapping("/")
	String index() {
		
		return "index";
	}
	
//	인증과 인가의 차이
//	인증:
//		출입증을 부여받는 행위
//	인가:
//		어디까지 접근을 허용할 것인가?
//
//권한 제어 방식
//	level로 권한 관리
//		0, 1, 2 이런식으로 단계에 따라 권한 제어
//	RBA
//		Role Base: 권한 제어
//
	@GetMapping("/login")
	String login() {
		
		return "login";
	}
	
	
	//Session
	//	왜 필요한가?
	//		http프로토콜 때문에 필요함.
//				상태가 없는 프로토콜
//					상태가 왜 없는가?
//						request, response 밖에 없음.
//						각각의 요청과 응답이기 때문에 그때그때 처리함.
//				http프로토콜이 간단해서 널리 쓰이고 인기 있었음
//				치명적인 단점.
//				pull 방식이다 ex)sms같은 것들에는 이용할 수 없음. (구조적인 문제)
//				문제점을 감안하고도 편리하기 때문에 사용함.
//		위의 사항을 보완하기 위해서 만들어진 것이 세션이다.
//		쿠키:
//			클라이언트에 저장하는 웹 브라우저 기술
//		
//		어떻게 동작하는가?
//			이 사람에 대한 세션을 만들고 키를 만들고 이 키를 응답을 보낼때 같이 보냄.
//			이 응답을 쿠키에 저장함.
//			WAS가 session에 저장해서 응답을 보낼때 세션을 같이 보내주고
//			클라이언트에서 세션의 값을 쿠키에 저장하고 이를 다음 요청때 사용함.
//	Session -> SSO -> TOKEN
	
//	현재 우리는 하나의 WAS에서 동작한다고 가정하고 Session을 사용함.
				
	@PostMapping("/login")
	String login(Users users, HttpSession session) {	//HttpSession은 서블릿 기술이다. 서블릿에 이런 것들이 들어있다는 것을 알 수 있음.
		
		Boolean result = usersService.login(users);
		
		if (result) {
            session.setAttribute("users", users);	//세션에 users라는 이름으로 Users에 담긴 값을 복사해서 저장함.
           
            return "redirect:/";
        } else {
        	System.out.println("로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
        		
            return "login";
        }
	}
	
	@GetMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	//회원가입
	@GetMapping("/register")
	String addUser() {
		
		return "register";
	}
	
	@PostMapping("/register")
	String addUser(Users user) {
		usersService.addUser(user);
		
		return "redirect:list";
		//redirect란?
			//request가 왔을때 처리 후 다시 표시할 페이지로 request를 새로 만들어서 리스트 주소로 보내줌.
			//request가 두번 왔다갔다함.
		
		//foward
			//위에 있는 리스트로 보내면 디비에서 목록을 읽어서 다시 리스트로 보내줌
			//문제가 생김
				//실제 주소가 이전 주소에 머물러 있기 때문에 새로고침시 다시 post 되면서 같은 정보가 여러번 등록되는 문제가 생길수있음.
	}
}
