package com.sami.ecommerceapplication.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/remove_from_cart")
public class RemoveFromCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  doGet logic (if any) goes here

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
//			HttpSession session = request.getSession();
//			session.removeAttribute("cart_" + id);
//			response.sendRedirect("cart");
		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}