package com.sami.ecommerceapplication.servlet;
<<<<<<< HEAD
=======

>>>>>>> bdd7566f434dd920b6db36f8161d681cd9e08bf6
import com.sami.ecommerceapplication.model.Cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
<<<<<<< HEAD
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
=======

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

>>>>>>> bdd7566f434dd920b6db36f8161d681cd9e08bf6
@WebServlet(name = "AddToCartServlet", value = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
<<<<<<< HEAD
		try (PrintWriter out = response.getWriter()) {
			// Retrieve the product ID from the request parameter
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Cart> cartList = new ArrayList<Cart>();
			System.out.println("this is the cart list "+ cartList);
=======

		try (PrintWriter out = response.getWriter()) {
			// Retrieve the product ID from the request parameter
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Cart> cartList = new ArrayList<>();

>>>>>>> bdd7566f434dd920b6db36f8161d681cd9e08bf6
			// Create a Cart object representing the product with quantity 1
			Cart cart = new Cart();
			cart.setId(id);
			cart.setQuantity(1);
<<<<<<< HEAD
			// Retrieve the user's session
			HttpSession session = request.getSession();
			// Retrieve the existing cart list from the session

=======

			// Retrieve the user's session
			HttpSession session = request.getSession();

			// Retrieve the existing cart list from the session
>>>>>>> bdd7566f434dd920b6db36f8161d681cd9e08bf6
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
			if (cart_list == null) {
				cartList.add(cart);
				session.setAttribute("cart_list", cartList);
				out.println("<h1>the cart is added to the cart list</h1>");
				System.out.println("the cart is added to the cart list");
			} else {
				cartList = cart_list;
				boolean isProductFound = false;
				for (Cart c : cartList) {
					if (c.getId() == id) {
<<<<<<< HEAD
						out.println("<h2 style='color:crimson;text-align:center'>Item Already Exist <a href='cart'>back to cart page </a></h2>");
=======
						out.println("product exists in the cart list");

>>>>>>> bdd7566f434dd920b6db36f8161d681cd9e08bf6
//						c.setQuantity(c.getQuantity() + 1);
						isProductFound = true;
//						break;
					}
<<<<<<< HEAD
=======

>>>>>>> bdd7566f434dd920b6db36f8161d681cd9e08bf6
				}
				if (!isProductFound) {
					cartList.add(cart);
					session.setAttribute("cart_list", cartList);
<<<<<<< HEAD
					response.sendRedirect("index");
				}
			}
		}
	}
=======
					out.println("<h1>the cart is added to the cart list</h1>");
					System.out.println("the cart is added to the cart list");
				}

			}
		}
	}

>>>>>>> bdd7566f434dd920b6db36f8161d681cd9e08bf6
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// This servlet does not handle POST requests, so this method is empty
	}
}
