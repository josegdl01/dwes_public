<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.Writer" %>
<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 16/11/2023
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <nav>
        <a href="${pageContext.request.contextPath}/Menu">Volver</a>
        <a href="${pageContext.request.contextPath}/LogoutServlet">Salir</a>
        <br>
        <c:if test="${user != null && user.getRole().equals('user')}">
            <p>
                Sesion de administrador iniciada por ${user.getName()}
            </p>
        </c:if>

        <c:if test="${user != null && user.getRole().equals('admin')}">
            <p>
                Sesion de usuario iniciada por ${user.getName()}
            </p>
        </c:if>
    </nav>

</header>
</body>
</html>

