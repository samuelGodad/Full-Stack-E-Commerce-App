package com.sami.ecommerceapplication.servlet;
import com.sami.ecommerceapplication.model.Cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			// Retrieve the product ID from the request parameter
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Cart> cartList = new ArrayList<>();
			// Create a Cart object representing the product with quantity 1
			Cart cart = new Cart();
			cart.setId(id);
			cart.setQuantity(1);
			// Retrieve the user's session
			HttpSession session = request.getSession();
			// Retrieve the existing cart list from the session
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
			if (cart_list == null) {
				cartList.add(cart);
				session.setAttribute("cart_list", cartList);
				response.sendRedirect(request.getContextPath() + "/");
			} else {
				cartList = cart_list;
				boolean isProductFound = false;
				for (Cart c : cartList) {
					if (c.getId() == id) {

						out.println("<h2 style='color:crimson;text-align:center'>Item Already Exist <a href='cart'>back to cart page </a></h2>");
						isProductFound = true;
//
					}

				}
				if (!isProductFound) {
					cartList.add(cart);
					session.setAttribute("cart_list", cartList);
					response.sendRedirect(request.getContextPath() + "/");
				}
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// This servlet does not handle POST requests, so this method is empty
	}
}