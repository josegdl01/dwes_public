<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 14/12/2023
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inicio de la APP</title>
</head>
<body>
<c:if test="${sessionScope.usuario.getRole().equals('user')}">
    <h1>Categorías Disponibles</h1>
    <ul>
        <c:forEach var="cat" items="${sessionScope.categorias}">
            <li><a href="MostrarProducto?cat=${cat}">${cat}<a/></li>
        </c:forEach>
    </ul>
</c:if>

<c:if test="${usuario.getRole().equals('admin')}">
    <ul>
        <li><a href="${pageContext.request.contextPath}/Admin/Empleados">Mostrar Empleados</a></li>
        <li><a href="${pageContext.request.contextPath}/Admin/AddEmpleado">Añadir Empleado</a></li>
    </ul>
</c:if>
</body>
</html>
