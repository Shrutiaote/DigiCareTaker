package com.digicaretaker.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digicaretaker.entity.Users;
import com.digicaretaker.service.UserService;
import com.digicaretaker.serviceimpl.UserServiceimpl;


@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int user_id = Integer.parseInt(request.getParameter("id"));

	        Users user = userService.getUserById(user_id);

	        request.setAttribute("user", user);

	        request.getRequestDispatcher("admin/edit-user.jsp")
	               .forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
