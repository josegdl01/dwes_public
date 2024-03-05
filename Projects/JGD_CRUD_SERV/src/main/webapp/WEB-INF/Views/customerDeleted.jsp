<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 30/10/2023
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Página resultante de borrar un Cliente</title>
</head>
<body>
<div class="container mt-5">
    <div class="justify-content-center mt-5">
        <c:if test="${sessionScope.clienteBorrado != null}">
            <h1>Borrado el cliente <c:out value="${sessionScope.clienteBorrado}"/></h1>
        </c:if>
        <c:if test="${sessionScope.clienteBorrado == null}">
            <h1>Este cliente no existe</h1>
        </c:if>
        <br><a href="${pageContext.request.contextPath}/Menu">Volver al menú</a>
    </div>
</div>
</body>
</html>
