package com.digicaretaker.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

	        e.printStackTrace();

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
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		        String hql = "FROM Users WHERE email = :email";

		        Query<Users> query = session.createQuery(hql, Users.class);
		        query.setParameter("email", email);

		        return query.uniqueResult();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

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
