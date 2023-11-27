<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 23/10/2023
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Introducción de un ID para borrar un cliente</title>
</head>
<body>
    <h1>DELETE</h1>
    <h2>Introduzca el ID del cliente que desee borrar</h2>
    <form method="POST">
        <label for="customerId">Customer's ID</label><input id="customerId" type="text" name="customerId"><br>
        <button type="submit" name="submit">Borrar</button>
    </form>
    <br><p><a href="${pageContext.request.contextPath}/MenuServlet">Volver al menú</a></p>
</body>
</html>
