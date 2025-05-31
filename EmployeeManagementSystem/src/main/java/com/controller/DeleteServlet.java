package com.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDAO;
import com.model.Employee;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
	
		EmployeeDAO dao = new EmployeeDAO();
		
		try {
			dao.deleteEmployee(email);
			dao.commit();
			response.sendRedirect("findAll");
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
}
