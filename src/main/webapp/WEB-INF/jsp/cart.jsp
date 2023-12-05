<%@ page import="com.sami.ecommerceapplication.model.User" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sami.ecommerceapplication.model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sami.ecommerceapplication.dao.ProductDao" %>
<%@ page import="com.sami.ecommerceapplication.connection.DataBaseConnector" %>
<%@ page import="java.text.DecimalFormat" %>

<%--
  Created by IntelliJ IDEA.
  User: Sami
  Date: 11/27/2023
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>

<%
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
	request.setAttribute("decimalFormat", decimalFormat);

    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart_list");
    List<Cart> cartProducts = null;
    if (cart_list != null) {
        ProductDao productDao = new ProductDao(DataBaseConnector.getConnection());
        cartProducts = productDao.getAllCartProducts(cart_list);
		request.setAttribute("total_price", productDao.totalCartPrice(cart_list));
        request.setAttribute("cart_list", cart_list);


    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carts</title>
    <%@include file="../includes/headers.jsp" %>
    <link rel="stylesheet" href="css/cart.css">
</head>
<body>
<%@include file="../includes/navbar.jsp" %>
<div class="container">
    <div class="d-flex py-3">
        <h3>Total Price : $ ${total_price > 0 ? decimalFormat.format(total_price) :0}</h3>
        <a href="#" class="mx-3 btn btn-primary">Checkouts</a>
    </div>
    <table class="table table-long">
        <thead>
        <tr>
            <th scope="col"> Name</th>
            <th scope="col"> Category</th>
            <th scope="col"> Price</th>
            <th scope="col"> Buy Now</th>
            <th scope="col"> Cancel</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (cartProducts != null) {
                for (Cart cart : cartProducts) {%>
        <tr>
            <td><%= cart.getName()%>
            </td>
            <td><%=cart.getCategory()%>
            </td>
            <td> $<%= decimalFormat.format(cart.getPrice())%>
            </td>
            <td>
                <form action="order_now" method="post" class="form-inline">
                    <input type="hidden" name="id" value="<%=cart.getId()%>" class="form-input">
                    <div class="form-group d-flex justify-content-between">
                        <a href="quantity_dec_and_inc?action=dec&id=<%=cart.getId()%>" class="btn  btn-incr "><i class="fa fa-minus-square"></i></a>
                        <input type="text" name="quantity" value="<%=cart.getQuantity()%>" class="form-control w-50" readonly>
                        <a href="quantity_dec_and_inc?action=inc&id=<%=cart.getId()%>" class="btn btn btn-decr"><i class="fa fa-plus-square"></i></a>
                    </div>
                    <button type="submit" class="btn btn-secondary">Buy Now</button>
                </form>
            </td>
            <td><a href="remove_from_cart?id=<%=cart.getId()%>" class="btn btn-danger"> Remove </a></td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>

<%@ include file="../includes/footer.jsp" %>
</body>
</html>
