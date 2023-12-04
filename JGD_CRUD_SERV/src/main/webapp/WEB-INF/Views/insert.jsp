<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 23/10/2023
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Formulario para introducir nuevo Cliente</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>INSERT</h1>
    <form method="POST">
        <label for="customerId">Customer's ID:</label><input id="customerId" type="text" name="CustomerId"><br>
        <label for="CustomerTaxCode">Customer's Tax Code:</label><input id="CustomerTaxCode" type="text" name="CustomerTaxCode"><br>
        <label for="CustomerBusName">Customer's Bus Name:</label><input id="CustomerBusName" type="text" name="CustomerBusName"><br>
        <label for="CustomerAddress">Customer's Address:</label><input id="CustomerAddress" type="text" name="CustomerAddress"><br>
        <label for="CustomerPhone">Customer's Phone:</label><input id="CustomerPhone" type="text" name="CustomerPhone"><br>
        <button type="submit" name="submit">Enviar</button>
    </form>
    <br><p><a href="${pageContext.request.contextPath}/Menu">Volver al menú</a></p>
</body>
</html>
