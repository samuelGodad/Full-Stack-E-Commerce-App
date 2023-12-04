<%--
  Created by IntelliJ IDEA.
  User: Sami
  Date: 11/28/2023
  Time: 6:55 AM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href=""> E-Commerce Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon">current</span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="cart">carts<span class ="badge badge-danger">${cart_list.size()}</span></a>
                </li>
                <%
                    if (auth != null) {%>
                <li class="nav-item"><a class="nav-link disabled" href="order"> orders </a></li>
                <li class="nav-item"><a class="nav-link disabled" href="log_out"> LogOut </a></li>

                <%} else {%>
                <li class="nav-item"><a class="nav-link disabled" href="login"> Login </a></li>
                <%
                    }
                %>
            </ul>

        </div>
    </div>
</nav>
<%@ include file="../includes/footer.jsp" %>
