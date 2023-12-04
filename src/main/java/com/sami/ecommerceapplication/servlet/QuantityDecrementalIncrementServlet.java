package com.sami.ecommerceapplication.servlet;

import com.sami.ecommerceapplication.model.Cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/quantity_dec_and_inc")
public class QuantityDecrementalIncrementServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		try {
			PrintWriter out = response.getWriter();

			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			String quantity = request.getParameter("quantity");
			ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cart_list");
			if (action != null && id >= 1) {
				if (action.equals("dec")) {
					for (Cart cart : cartList) {
						if (cart.getId() == id) {
							if (cart.getQuantity() > 1) {
								cart.setQuantity(cart.getQuantity() - 1);
							}
						}
					}
					response.sendRedirect("cart");
				} else if (action.equals("inc")) {
					for (Cart cart : cartList) {
						if (cart.getId() == id) {
							cart.setQuantity(cart.getQuantity() + 1);
						}

					}
					response.sendRedirect("cart");
				}
			} else {
				out.println("<h2 style='color:crimson;text-align:center'>No item remain all are removed  <a href='cart'>back to cart page </a></h2>");
			}

		} catch (Exception e) {
			e.printStackTrace();


		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


}