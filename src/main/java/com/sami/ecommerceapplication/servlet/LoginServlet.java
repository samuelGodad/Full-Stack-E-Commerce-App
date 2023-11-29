package com.sami.ecommerceapplication.servlet;

import com.sami.ecommerceapplication.connection.DataBaseConnector;
import com.sami.ecommerceapplication.dao.UserDao;
import com.sami.ecommerceapplication.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/user_login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("login_email");
			String password = request.getParameter("login_password");
			out.println(email + password);
			UserDao userDao = new UserDao(DataBaseConnector.getConnection());
			User user = userDao.userLogin(email, password);
			if (user != null) {
				request.getSession().setAttribute("auth", user);
				response.sendRedirect("helloServlet");
			} else {
				out.println("login fail ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("you can redirect to the jsp page");
		}
	}
}
//ebook management system
// Ethiopian airline ticket management system
// e-doctor
