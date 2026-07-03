package com.digicaretaker.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digicaretaker.serviceimpl.UserServiceimpl;
import com.digicaretaker.entity.Users;
import com.digicaretaker.service.UserService;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceimpl();

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int user_id =
	                Integer.parseInt(request.getParameter("user_id"));

	        Users user =
	                userService.getUserById(user_id);

	        user.setFirstName(request.getParameter("firstName"));
	        user.setLastName(request.getParameter("lastName"));
	        user.setPhone(request.getParameter("phone"));
	        user.setAddress(request.getParameter("address"));
	        user.setStatus(request.getParameter("status"));

	        boolean updated =
	                userService.updateUser(user);

	        if(updated) {
	            response.sendRedirect("ViewUserServlet");
	        } else {
	            response.sendRedirect("admin/edit-user.jsp");
	        }
	}

}
