<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 23/10/2023
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Cliente seleccionado en base a un SELECT</title>
</head>
<body>
    <h1>Cliente seleccionado: <c:out value="${customerRead.cusId}"/> </h1>
    <h2>Customer´s Tax Code: <c:out value="${customerRead.cusTaxCode}"/></h2>
    <h2>Customer´s Bus Name: <c:out value="${customerRead.cusBusName}"/> </h2>
    <h2>Customer´s Address: <c:out value="${customerRead.cusAddress}"/> </h2>
    <h2>Customer´s Phone: <c:out value="${customerRead.cusPhone}"/> </h2>
    <br><p><a href="${pageContext.request.contextPath}/MenuServlet">Volver al menú</a></p>
</body>
</html>