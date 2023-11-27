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
        <a href="${pageContext.request.contextPath}/VolverServlet">Volver</a>
        <a href="${pageContext.request.contextPath}/LogoutServlet">Salir</a>
        <br>
        <c:if test="${sessionScope.sesionCorrecta != null && sessionScope.sesionCorrecta && sessionScope.momentoInicio != null}">
            <p>
                Sesion de administrador iniciada a las ${sessionScope.momentoInicio}
            </p>
        </c:if>

        <c:if test="${sessionScope.sesionCorrecta != null && !sessionScope.sesionCorrecta && sessionScope.momentoInicio != null}">
            <p>
                Sesion de usuario iniciada a las ${sessionScope.momentoInicio}
            </p>
        </c:if>
    </nav>

</header>
</body>
</html>

