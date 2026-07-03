package com.digicaretaker.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digicaretaker.serviceimpl.UserServiceimpl;
import com.digicaretaker.entity.Users;
import com.digicaretaker.service.UserService;

@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
		 private UserService userService = new UserServiceimpl();

		    	@Override
		    	protected void doGet(HttpServletRequest request,
		    	        HttpServletResponse response)
		    	        throws ServletException, IOException {

		    		 String keyword = request.getParameter("keyword");

		    	        List<Users> users;

		    	        if (keyword == null || keyword.trim().isEmpty()) {
		    	            users = userService.getAllUsers();
		    	        } else {
		    	            users = userService.searchUsers(keyword);
		    	        }

		    	        request.setAttribute("users", users);

		    	        request.getRequestDispatcher("admin/users.jsp")
		    	               .forward(request, response);
		    	    }
		    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
