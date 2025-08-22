package kr.co.kopo.service;

import java.util.List;

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

}
