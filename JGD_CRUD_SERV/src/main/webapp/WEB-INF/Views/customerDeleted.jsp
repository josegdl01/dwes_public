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
    <h1>Borrado el cliente <c:out value="${sessionScope.clienteBorrado}"/></h1>
    <br><a href="${pageContext.request.contextPath}/MenuServlet">Volver al menú</a>
</body>
</html>
