package com.digicaretaker.serviceimpl;

import com.digicaretaker.DAO.UserDAO;
import com.digicaretaker.daoimpl.UserDAOImpl;
import com.digicaretaker.entity.Users;
import com.digicaretaker.service.UserService;

public class UserServiceimpl implements UserService{

	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public boolean registerUser(Users user) {
		// TODO Auto-generated method stub
		return userDAO.saveUser(user);
	}

	@Override
	public Users loginUser(String email, String password) {
		// TODO Auto-generated method stub
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

}
