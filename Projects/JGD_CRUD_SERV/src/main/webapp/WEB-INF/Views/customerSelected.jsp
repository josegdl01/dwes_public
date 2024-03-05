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
    <meta charset="UTF-8">
    <jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center mt-5">
        <c:if test="${sessionScope.customerSelected != null}">
            <h1>Cliente seleccionado: <c:out value="${customerSelected.cusId}"/> </h1>
            <h2>Customer´s Tax Code: <c:out value="${customerSelected.cusTaxCode}"/></h2>
            <h2>Customer´s Bus Name: <c:out value="${customerSelected.cusBusName}"/> </h2>
            <h2>Customer´s Address: <c:out value="${customerSelected.cusAddress}"/> </h2>
            <h2>Customer´s Phone: <c:out value="${customerSelected.cusPhone}"/> </h2>
        </c:if>
        <c:if test="${sessionScope.customerSelected == null}">
            <h1>El cliente no se encuentra en la base de datos</h1>
        </c:if>
        <br><p><a href="${pageContext.request.contextPath}/Menu">Volver al menú</a></p>
    </div>
</div>
</body>
</html>
