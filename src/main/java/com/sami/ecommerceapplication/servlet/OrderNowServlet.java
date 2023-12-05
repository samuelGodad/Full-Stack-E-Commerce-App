package com.sami.ecommerceapplication.servlet;
import java.sql.Timestamp;
import com.sami.ecommerceapplication.connection.DataBaseConnector;
import com.sami.ecommerceapplication.dao.OrderDao;
import com.sami.ecommerceapplication.model.Cart;
import com.sami.ecommerceapplication.model.Order;
import com.sami.ecommerceapplication.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/order_now")
public class OrderNowServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Date date = new Date();
			User auth = (User)request.getSession().getAttribute("auth") ;
			if(auth !=null){
				String id = request.getParameter("id");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				if (quantity <= 0) {
					quantity = 1;
				}
				Order order = new Order();
				order.setId(Integer.parseInt(id));
				order.setQuantity(quantity);
				order.setDate(new Timestamp(date.getTime()));
				order.setUser_id(auth.getId());
				OrderDao orderDao =new  OrderDao(DataBaseConnector.getConnection());
				boolean result=orderDao.insertOrder(order);
				if (result) {
					ArrayList<Cart> cart_list=(ArrayList<Cart>)request.getSession().getAttribute("cart_list");
					if(cart_list!=null){
						for (Cart cart : cart_list) {
							if (cart.getId() == Integer.parseInt(id)) {
								cart_list.remove(cart);
								break;
							}
						}

					}
					response.sendRedirect("order");
				} else {
					PrintWriter out = response.getWriter();
					out.println("Error: Order not placed");
				}

			}else {
				response.sendRedirect("login_page");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
