package com.digicaretaker.util;

import org.hibernate.SessionFactory;

public class HibernateTest {

	 public static void main(String[] args) {

	        SessionFactory factory =
	                HibernateUtil.getSessionFactory();

	        System.out.println("Hibernate Connected Successfully!");

	        factory.close();
	    }
}
