<%--
  Created by IntelliJ IDEA.
  User: Sami
  Date: 12/4/2023
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.sami.ecommerceapplication.model.Product" %>
<%@ page import="com.sami.ecommerceapplication.dao.ProductDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sami.ecommerceapplication.connection.DataBaseConnector" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ProductDao productDao = new ProductDao(DataBaseConnector.getConnection());

    List<Product> products = productDao.getAllProducts();
	Product product = new Product();

%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>the item <%= product.getName()%> is added to the cart successfully <a href="cart">go to cart</a></h1>



</body>
</html>
