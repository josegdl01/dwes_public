<%--
  Created by IntelliJ IDEA.
  User: José
  Date: 03/12/2023
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center mt-5">
        <h1>Seleccione una opción</h1>
        <button class="btn btn-primary w-100 mt-3"><h2><a style="color: white" href="${pageContext.request.contextPath}/CambiarCon">Modificar
            Contraseña</a></h2></button>
        <button class="btn btn-primary w-100 mt-3"><h2><a style="color: white" href="${pageContext.request.contextPath}/CambiarNom">Modificar
            Nombre de usuario</a></h2></button>
        <button class="btn btn-primary w-100 mt-3"><h2><a style="color: white" href="${pageContext.request.contextPath}/CambiarEmail">Modificar
            Email</a></h2></button>
    </div>
</div>
</body>
</html>
