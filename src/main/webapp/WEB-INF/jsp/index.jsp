<%@ page import="com.sami.ecommerceapplication.connection.DataBaseConnector" %>
<%@ page import="com.sami.ecommerceapplication.model.User" %>
<%@ page import="com.sami.ecommerceapplication.model.Product" %>
<%@ page import="com.sami.ecommerceapplication.servlet.pagedispatcher.PageDispatcherServlets" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sami.ecommerceapplication.dao.ProductDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
    ProductDao productDao = new ProductDao(DataBaseConnector.getConnection());
    List<Product> products = productDao.getAllProducts();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Shopping Cart</title>
    <%@ include file="../includes/headers.jsp" %>
    <%@ include file="../includes/navbar.jsp" %>
</head>
<body>
<div class="container">
    <h1>All Products</h1>

    <div class="card-header my-3"></div>
    <div class="row">
        <%
            if (!products.isEmpty()) {
                for (Product product : products) {%>
        <div class="col-md-3 my-3">
            <div class="card w-100" style="width:18rem">
                <img src="projectImages/<%=product.getImage()%>" alt="Card image cap" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title"><%= product.getName()%></h5>
                    <h6 class="price">Price: $<%= product.getPrice()%></h6>
                    <h6 class="category">Category :<%= product.getCategory() %></h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a href="add-to-cart?id=<%=product.getId()%>" class="btn btn-dark">Add to Cart</a>
                        <a href="#" class="btn btn-primary">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>

    </div>
</div>
</body>
</html>
