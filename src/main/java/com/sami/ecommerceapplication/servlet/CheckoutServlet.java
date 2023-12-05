package com.sami.ecommerceapplication.servlet;

import com.sami.ecommerceapplication.connection.DataBaseConnector;
import com.sami.ecommerceapplication.dao.OrderDao;
import com.sami.ecommerceapplication.model.Cart;
import com.sami.ecommerceapplication.model.Order;
import com.sami.ecommerceapplication.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/check_out")
public class CheckoutServlet extends HttpServlet{

	protected  void  doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
		//  doPost logic (if any) goes here
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			Date date = new Date();
			ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cart_list");
			User auth = (User)request.getSession().getAttribute("auth") ;

				if (auth != null && cartList != null) {
					for (Cart cart : cartList) {
						Order order =new Order();
						order.setId(cart.getId());
						order.setQuantity(cart.getQuantity());
						order.setUser_id(auth.getId());
						order.setDate(new Timestamp(date.getTime()));
						OrderDao orderDao = new OrderDao(DataBaseConnector.getConnection());
						boolean result =orderDao.insertOrder(order);
						if (!result) {
							break;
						}
						cartList.clear();
						response.sendRedirect("order");
					}
				} else {
					if(auth == null){
						response.sendRedirect("login_page");
					}
					response.sendRedirect("cart");
				}



		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
		}
	}
	protected  void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
		//  doPost logic (if any) goes here


	}

}
