<%--
  Created by IntelliJ IDEA.
  User: José
  Date: 22/11/2023
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Botones para salir o volver a Menú</title>
</head>
<body>
<button><a href="${pageContext.request.contextPath}/LogoutServlet">SALIR</a></button>
<button><a href="${pageContext.request.contextPath}/MenuServlet">VOLVER AL MENÚ</a></button>
</body>
</html>
