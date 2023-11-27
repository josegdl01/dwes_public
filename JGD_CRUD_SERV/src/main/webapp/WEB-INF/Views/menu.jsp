<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta charset="UTF-8">
</head>
<body>
<br/>
<h1>Seleccione una opción</h1>
<h2><a href="${pageContext.request.contextPath}/InsertServlet">Insertar cliente</a></h2>
<h2><a href="${pageContext.request.contextPath}/ReadServlet">Leer cliente</a></h2>
<h2><a href="${pageContext.request.contextPath}/DeleteServlet">Borrar cliente</a></h2>
<h2><a href="${pageContext.request.contextPath}/UpdateServlet">Modificar cliente</a></h2>
</body>
</html>