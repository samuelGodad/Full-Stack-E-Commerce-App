<%@ page import="com.sami.ecommerceapplication.connection.DataBaseConnector" %>
<%@ page import="com.sami.ecommerceapplication.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }
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
    <div class="card-header my-3"></div>
    <div class="row">
        <div class="col-md-3">
            <div class="card w-100" style="width:18rem">
                <!-- Fix the path to the image -->
                <img src="projectImages/female-shoes.jpg" alt="Card image cap" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title"></h5>
                    <h6 class="price">Price: $453</h6>
                    <h6 class="category">Category: Some Category</h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a href="#" class="btn btn-primary">Add to Cart</a>
                        <a href="#" class="btn btn-primary">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<h1>This is the home page</h1>
</body>
</html>
