package kr.co.kopo.dao;

import java.util.List;

import kr.co.kopo.model.Users;


public interface UsersDao {

	List<Users> getUsers();

	void addUser(Users user);

	void deleteUser(String id);

	void updateUser(Users user);

	Users getUser(String id);

}
