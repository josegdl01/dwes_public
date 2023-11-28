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
<h2><a href="${pageContext.request.contextPath}/Menu/Insert">Insertar cliente</a></h2>
<h2><a href="${pageContext.request.contextPath}/Menu/Read">Leer cliente</a></h2>
<h2><a href="${pageContext.request.contextPath}/Menu/Delete">Borrar cliente</a></h2>
<h2><a href="${pageContext.request.contextPath}/Menu/Update">Modificar cliente</a></h2>
</body>
</html>