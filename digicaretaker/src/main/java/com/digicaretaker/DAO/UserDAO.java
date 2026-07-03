package com.digicaretaker.DAO;

import java.util.List;

import com.digicaretaker.entity.Users;

public interface UserDAO {

	    boolean saveUser(Users user);

	    Users getUserByEmail(String email);
	    
	    Users getUserById(int user_id);
	    
	    List<Users> getAllUsers();

	    boolean updateUser(Users user);

	    boolean deleteUser(int user_id);
	    
	    List<Users> searchUsers(String keyword);
}
