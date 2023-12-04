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
    <title>Entrada de un id para realizar una consulta SELECT a la base de datos</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>SELECT</h1>
    <form method="POST">
        <label for="CustomerId">Customer's ID:</label><input id="CustomerId" type="text" name="CustomerId"><br>
            <button type="submit" name="submit">Enviar</button>
            <br><p><a href="${pageContext.request.contextPath}/Menu">Volver al menú</a></p>
    </form>
</body>
</html>
