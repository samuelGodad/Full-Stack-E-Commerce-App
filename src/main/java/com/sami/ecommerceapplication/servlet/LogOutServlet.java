package com.sami.ecommerceapplication.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "LogOutServlet", value = "/log_out")
public class LogOutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			if (request.getSession().getAttribute("auth") != null) {
				request.getSession().removeAttribute("auth");
				response.sendRedirect("login");
			} else {
				// If not logged in, redirect back to the referring page
				String referer = request.getHeader("referer");
				// If no referring page, redirect to a default page
				response.sendRedirect(Objects.requireNonNullElse(referer, ""));
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Your doPost logic (if any) goes here
	}
}
