package com.digicaretaker.daoimpl;

import java.util.List;

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
		Transaction transaction = null;

	    try(Session session =
	            HibernateUtil.getSessionFactory().openSession()) {

	        transaction = session.beginTransaction();

	        session.update(user);

	        transaction.commit();

	        return true;

	    } catch(Exception e) {

	        if(transaction != null) {
	            transaction.rollback();
	        }

	        e.printStackTrace();
	    }

	    return false;
	}

	@Override
	public boolean deleteUser(int user_id) {
		 Transaction transaction = null;

		    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		        transaction = session.beginTransaction();

		        Users user = session.get(Users.class, user_id);

		        if (user != null) {
		            session.delete(user);
		            transaction.commit();
		            return true;
		        }

		    } catch (Exception e) {

		        if (transaction != null) {
		            transaction.rollback();
		        }

		        e.printStackTrace();
		    }

		    return false;
	}

	@Override
	public Users getUserById(int user_id) {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		        return session.get(Users.class, user_id);

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return null;
	}

	@Override
	public List<Users> getAllUsers() {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {

		        String hql = "FROM Users";

		        Query<Users> query = session.createQuery(hql, Users.class);

		        return query.list();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return null;
	}

	@Override
	public List<Users> searchUsers(String keyword) {
		 try(Session session =
		            HibernateUtil.getSessionFactory().openSession()) {

		        String hql =
		        "FROM Users WHERE firstName LIKE :key "
		      + "OR lastName LIKE :key "
		      + "OR email LIKE :key "
		      + "OR phone LIKE :key";

		        Query<Users> query =
		                session.createQuery(hql, Users.class);

		        query.setParameter("key", "%" + keyword + "%");

		        return query.list();

		    }
	}

}
