package com.digicaretaker.serviceimpl;

import java.util.List;

import com.digicaretaker.DAO.UserDAO;
import com.digicaretaker.daoimpl.UserDAOImpl;
import com.digicaretaker.entity.Users;
import com.digicaretaker.service.UserService;

public class UserServiceimpl implements UserService{

	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public boolean registerUser(Users user) {
		
		return userDAO.saveUser(user);
	}

	@Override
	public Users loginUser(String email, String password) {
		 Users user = userDAO.getUserByEmail(email);

		    if (user != null && user.getPassword().equals(password)) {
		        return user;
		    }

		    return null;
	}

	@Override
	public Users getUserById(int user_id) {
		
		return userDAO.getUserById(user_id);
	}

	@Override
	public boolean updateUser(Users user) {
		return userDAO.updateUser(user);
	}

	@Override
	public boolean deleteUser(int user_id) {
		return userDAO.deleteUser(user_id);
	}

	@Override
	public List<Users> getAllUsers() {
		return userDAO.getAllUsers();
	}
	
	@Override
	public List<Users> searchUsers(String keyword) {
	    return userDAO.searchUsers(keyword);
	}

}
