package com.sami.ecommerceapplication.servlet;

import com.sami.ecommerceapplication.model.Cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/remove_from_cart")
public class RemoveFromCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  doGet logic (if any) goes here

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String id = request.getParameter("id");
			if(id != null){
				ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cart_list");
				for (Cart cart : cartList) {
					if (cart.getId() == Integer.parseInt(id)) {
						cartList.remove(cart);
						break;
					}
				}
				response.sendRedirect("cart");

			}else {
				response.sendRedirect("cart");
			}
		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
