<%@ page import="com.sami.ecommerceapplication.model.User" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sami.ecommerceapplication.model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sami.ecommerceapplication.dao.ProductDao" %>
<%@ page import="com.sami.ecommerceapplication.connection.DataBaseConnector" %>

<%--
  Created by IntelliJ IDEA.
  User: Sami
  Date: 11/27/2023
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
    ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart_list");
    List<Cart> cartProducts = null;
    if (cart_list != null) {
        ProductDao productDao = new ProductDao(DataBaseConnector.getConnection());
        cartProducts = productDao.getAllCartProducts(cart_list);
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
        <h3>Total Price:$456</h3>
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
            <td> $<%= cart.getPrice()%>
            </td>
            <td>
                <form action="" method="post" class="form-inline">

                    <input type="hidden" name="id" value="<%=cart.getId()%>" class="form-input">
                    <div class="form-group d-flex justify-content-between">
                        <a href="" class="btn  btn-incr "><i class="fa fa-minus-square"></i></a>
                        <input type="text" name="quantity" value="1" class="form-control" readonly>
                        <a href="" class="btn btn btn-decr"><i class="fa fa-plus-square"></i></a>
                    </div>
                </form>
            </td>
            <td><a href="#" class="btn btn-danger"> Remove </a></td>
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
