<%@ page import="com.sami.ecommerceapplication.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Sami
  Date: 11/27/2023
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User auth =(User) request.getSession().getAttribute("auth");
    if (auth != null){
        request.setAttribute("auth",auth);

    }
%>
<html>
<head>
    <title>Order</title>
    <%@include file="../includes/headers.jsp" %>
</head>
<body>
<%@include file="../includes/navbar.jsp" %>
</body>
</html>
