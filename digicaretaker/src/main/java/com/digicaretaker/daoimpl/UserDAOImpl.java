package com.digicaretaker.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.digicaretaker.DAO.UserDAO;
import com.digicaretaker.entity.Users;
import com.digicaretaker.util.HibernateUtil;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean saveUser(Users user) {

	    Transaction transaction = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

	        transaction = session.beginTransaction();

	        session.save(user);

	        transaction.commit();

	        return true;

	    } catch (Exception e) {

	        e.printStackTrace();   // Print the ORIGINAL exception first

	        try {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	        return false;
	    }
	}

	@Override
	public Users getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int user_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users getUserById(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
