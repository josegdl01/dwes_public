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
    <title>Formulario para cambiar los datos de un Cliente</title>
    <meta charset="UTF-8">
    <jsp:include page="include/bootstrap.jsp"/>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center mt-5">
        <h1>UPDATE</h1>
        <form method="POST">
            <label for="CusId">Customer's ID: </label><input id="CusId" type="text" name="CusId"><br>
            <label for="CusTax">Customer's Tax Code: </label><input id="CusTax" type="text" name="CusTax"><br>
            <label for="CusBus">Customer's Bus Name: </label><input id="CusBus" type="text" name="CusBus"><br>
            <label for="CusAd">Customer's Address: </label><input id="CusAd" type="text" name="CusAd"><br>
            <label for="CusPhone">Customer's Phone: </label><input id="CusPhone" type="text" name="CusPhone"><br>
            <button type="submit" name="submit">Enviar Datos</button>
        </form>
        <a href="${pageContext.request.contextPath}/Menu">Volver al menú</a>
    </div>
</div>
</body>
</html>
