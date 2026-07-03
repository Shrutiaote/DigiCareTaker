package com.digicaretaker.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digicaretaker.serviceimpl.UserServiceimpl;
import com.digicaretaker.entity.Users;
import com.digicaretaker.service.UserService;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceimpl();
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		if (session == null) {
		    response.sendRedirect("login.jsp");
		    return;
		}

		Users loggedInUser = (Users) session.getAttribute("loggedInUser");

		if (loggedInUser == null) {
		    response.sendRedirect("login.jsp");
		    return;
		}

		if (!"ADMIN".equalsIgnoreCase(loggedInUser.getRole().getRole_name())) {
		    response.sendRedirect("login.jsp");
		    return;
		}
		List<Users> users = userService.getAllUsers();

        request.setAttribute("users", users);

        request.getRequestDispatcher("admin/users.jsp")
               .forward(request, response);
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

