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
		response.sendRedirect("helloServlet");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <%@include file="../includes/headers.jsp" %>
</head>
<body>
<%@include file="../includes/navbar.jsp"%>
<div class="container" style="min-height: 50vh">
    <div class="card w-50 mx-auto my-5" style="min-height: 75vh">
        <div class="card-header text-center">
            User Login
        </div>
        <div class="card-body">
            <form action = "login" method="post">
                <!-- Email Input Group -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-envelope"></i>
                        </span>
                    </div>
                    <input type="email" class="form-control" placeholder="Enter your Email" name="login_email">
                </div>

                <!-- Password Input Group -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            <i class="fas fa-lock"></i>
                        </span>
                    </div>
                    <input type="password" class="form-control"  placeholder="*****"
                           name="login_password" required>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
