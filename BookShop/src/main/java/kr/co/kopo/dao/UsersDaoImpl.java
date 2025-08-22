package kr.co.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kopo.model.Users;


@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Users> getUsers() {

		return sql.selectList("users.getUsers");
	}

	@Override
	public void addUser(Users user) {

		sql.insert("users.addUser", user);
		// sql.insert("users.addUser", user); // 이거는 dao에서 처리하는 거라서 service에서는 필요없다.
		// dao에서 처리할 일은 없고, dao에서 처리한다.
		// dao는 비즈니스 로직을 처리하는 곳이 아니라, sql을 실행해서 결과를 받아오는 곳이다.
		// 그래서 dao에서는 sql을 실행해서 결과를 받아오고, 그 결과를 반환하는 역할만 한다.
		// dao는 비즈니스 로직을 처리하는 곳이 아니라, sql을 실행해서 결과를 받아오는 곳이다.
		// 그래서 dao에서는 sql을 실행해서 결과를 받아오고, 그 결과를 반환하는 역할만 한다.
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		sql.delete("users.deleteUser", id);
		
	}

	@Override
	public void updateUser(Users user) {
			sql.update("users.updateUser", user);		
	}

	@Override
	public Users getUser(String id) {

		return sql.selectOne("users.getUser", id);
	}

}
