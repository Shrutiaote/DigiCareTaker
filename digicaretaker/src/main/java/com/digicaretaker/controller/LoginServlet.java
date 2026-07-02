package com.digicaretaker.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digicaretaker.serviceimpl.UserServiceimpl;
import com.digicaretaker.entity.Users;
import com.digicaretaker.service.UserService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private UserService userService = new UserServiceimpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        Users user = userService.loginUser(email, password);

	        if (user != null) {

	            HttpSession session = request.getSession();

	            session.setAttribute("loggedInUser", user);

	            response.sendRedirect("home.jsp");

	        } else {

	            request.setAttribute("error", "Invalid Email or Password");

	            request.getRequestDispatcher("login.jsp")
	                   .forward(request, response);
	        }

	    }
	}


