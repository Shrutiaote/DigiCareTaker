package com.digicaretaker.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digicaretaker.entity.Role;
import com.digicaretaker.entity.Users;
import com.digicaretaker.service.UserService;
import com.digicaretaker.serviceimpl.UserServiceimpl;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = new Users();

        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setPhone(request.getParameter("phone"));
        user.setGender(request.getParameter("gender"));
        user.setAddress(request.getParameter("address"));

        String dob = request.getParameter("dateOfBirth");
        if (dob != null && !dob.isEmpty()) {
            user.setDateOfBirth(LocalDate.parse(dob));
        }

        user.setStatus("ACTIVE");
        user.setCreatedAt(LocalDateTime.now());

        int role_id = Integer.parseInt(request.getParameter("role_id"));

        Role role = new Role(role_id);

        user.setRole(role);

        boolean registered = userService.registerUser(user);

        if (registered) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("error", "Registration failed!");
            request.getRequestDispatcher("register.jsp")
                   .forward(request, response);
        }
    }
	}

