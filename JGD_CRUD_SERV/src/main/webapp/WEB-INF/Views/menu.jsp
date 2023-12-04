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
<button><h2><a href="${pageContext.request.contextPath}/Insert">Insertar cliente</a></h2></button>
<button><h2><a href="${pageContext.request.contextPath}/Read">Leer cliente</a></h2></button>
<button><h2><a href="${pageContext.request.contextPath}/Delete">Borrar cliente</a></h2></button>
<button><h2><a href="${pageContext.request.contextPath}/Update">Modificar cliente</a></h2></button><br>
<button><p><a href="${pageContext.request.contextPath}/AreaUsuario">Área de Usuario</a></p></button>
</body>
</html>