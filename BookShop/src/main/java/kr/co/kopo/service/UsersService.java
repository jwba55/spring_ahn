package kr.co.kopo.service;

import java.util.List;

import kr.co.kopo.model.Users;


public interface UsersService {

	List<Users> getUsers();

	void addUser(Users user);

	void updateUser(Users user);

	void deleteUser(String id);

	Users getUser(String id);

}
