package com.digicaretaker.service;

import java.util.List;

import com.digicaretaker.entity.Users;

public interface UserService {

	 boolean registerUser(Users user);

	    Users loginUser(String email, String password);

	    Users getUserById(int user_id);

	    boolean updateUser(Users user);

	    boolean deleteUser(int user_id);
	    
	    List<Users> getAllUsers();
	    
	    List<Users> searchUsers(String keyword);
}
