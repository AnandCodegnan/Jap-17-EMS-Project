package com.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;
@WebServlet("/saveuser")
public class SaveUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		employee.setName(request.getParameter("name"));
		employee.setEmail(request.getParameter("email"));
		employee.setPassword(request.getParameter("password"));
		employee.setAge(Integer.parseInt(request.getParameter("age")));
		employee.setGender(request.getParameter("gender"));
		employee.setMobile(request.getParameter("mobile"));
		employee.setDepartment(request.getParameter("department"));
		employee.setAddress(request.getParameter("address"));
		
		EmployeeDAO dao = new EmployeeDAO();
		
		try {
			boolean status =  dao.saveuser(employee);
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			if(status) {
				dao.commit();
				request.setAttribute("status", "Registred Successfully......");
				dispatcher.forward(request, response);
			}
			else {
				dao.rollback();
				request.setAttribute("status", "Registration Failed......");
				dispatcher.forward(request, response);
			}
		}
		catch(ClassNotFoundException  | SQLException e) {
			System.out.println(e);
		}
		
	}
}
