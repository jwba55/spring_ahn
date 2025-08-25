package kr.co.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.kopo.model.Users;


//요청을 가로채서 처리
public class UsersInterceptor extends HandlerInterceptorAdapter {

	//ctrl+space -> prehandle
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
//		세션이 안좋은 이유:
//			오래된 기술이라 처리할 방법이 없음
//				집어넣을땐 간편함.
//				꺼낼때는 방법이 없어서 casting을 해줘야하는데 casting이 안되는 오류가 발생할 수 있음.
//					이 위험에 대한 방안으로 generic을 사용함.
//					compile단계에서 오류를 찾기 위함
			
		if(users != null) {
			//로그인한 관리자
			if(users.getRole()==Users.USERS) {
				return true;
			}
			response.sendRedirect("/");
			return false;
		}
		//로그인 하지 않은 사람
		response.sendRedirect("/login");
		//이건 절대 주소이기 때문에 앞에 contextPath가 붙음.
		//운영 환경에서와 개발환경에서가 차이가 날 수 있기 때문에 운영환경에 맞춰서 contextPath를 떼주는 것이 좋음.
		return false;
	}
}
	
