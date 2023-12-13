<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 30/10/2023
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Página resultante de editar un Cliente</title>
    <meta charset="UTF-8">
    <jsp:include page="include/bootstrap.jsp"/>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center mt-5">
        <h1>Datos recibidos:</h1>
        <h1>Customer's ID: ${customerUpdated.cusId} </h1>
        <h2>Customer's Tax Code: ${customerUpdated.cusTaxCode}</h2>
        <h2>Customer's Bus Name: ${customerUpdated.cusBusName} </h2>
        <h2>Customer's Address: ${customerUpdated.cusAddress} </h2>
        <h2>Customer's Phone: ${customerUpdated.cusPhone} </h2>
        <br><p><a href="${pageContext.request.contextPath}/Menu">Volver al menú</a></p>
    </div>
</div>
</body>
</html>
