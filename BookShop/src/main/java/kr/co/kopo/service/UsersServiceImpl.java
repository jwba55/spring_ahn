package kr.co.kopo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kopo.dao.UsersDao;
import kr.co.kopo.model.Users;


@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao dao;
	
	@Override
	public List<Users> getUsers() {

		return dao.getUsers();
	}

	@Override
	public void addUser(Users user) {
		dao.addUser(user);
		// dao.addUser(user); // 이거는 dao에서 처리하는 거라서 service에서는 필요없다.
		// service에서 처리할 일은 없고, dao에서 처리한다.
		// service는 dao를 호출해서 결과를 받아오는 역할만 한다.
		// service는 비즈니스 로직을 처리하는 곳이 아니라, dao를 호출해서 결과를 받아오는 곳이다.
		// 그래서 service에서는 dao를 호출해서 결과를 받아오고, 그 결과를 반환하는 역할만 한다.
		// service는 비즈니스 로직을 처리하는 곳이 아니라, dao를 호출해서 결과를 받아오는 곳이다.
		// 그래서 service에서는 dao를 호출해서 결과를 받아오고, 그 결과를 반환하는 역할만 한다.
	}

	@Override
	public void updateUser(Users user) {
		dao.updateUser(user);
		
	}

	@Override
	public void deleteUser(String id) {

		dao.deleteUser(id);
	}

	@Override
	public Users getUser(String id) {

		return dao.getUser(id);
	}

	
	//DB에서 아이디 패스워드를 확인하게 되면 문제가 생길수 있음.
	//	이유:
	//		DB에 대한 직접 접근
	//			클라이언트가 해킹 당했을 경우 DB의 데이터가 노출될 위험이 있음.
	//		sql injection:
	//			SQL을 입력란에 넣어 DB를 공격하는 행위
	//	mabatis도 $, # 두 가지를 사용하는 방법이 있다.
	@Override
	public Boolean login(Users users) {
		Users getLogin = dao.getUser(users.getId());
		if(getLogin != null) {
			if(getLogin.getPassword().equals(users.getPassword())) {
				users.setPassword(null);
				
				return true;
			}
		} else {
			
			return false;
		}	

		
//		학위과정에서 했던 방법
//		Users getLogin = dao.login(users);
//		if(getLogin != null) {
//			BeanUtils.copyProperties(users, getLogin);
//			
//			users.setPassword(null);
//			
//			return true;
//		}
		
		return false;
	}

}
