package com.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;
@WebServlet("/findAll")
public class GetAllEmplyees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeDAO dao = new EmployeeDAO();
		try {
			List<Employee> empList = dao.findAll();
			request.setAttribute("empList", empList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewemps.jsp");
			dispatcher.forward(request, response);
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}
}