<%--
  Created by IntelliJ IDEA.
  User: José
  Date: 03/12/2023
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br/>
<h1>Seleccione una opción</h1>
<button><h2><a href="${pageContext.request.contextPath}/CambiarCon">Modificar Contraseña</a></h2></button>
<button><h2><a href="${pageContext.request.contextPath}/CambiarNom">Modificar Nombre de usuario</a></h2></button>
<button><h2><a href="${pageContext.request.contextPath}/CambiarEmail">Modificar Email</a></h2></button>
</body>
</html>
