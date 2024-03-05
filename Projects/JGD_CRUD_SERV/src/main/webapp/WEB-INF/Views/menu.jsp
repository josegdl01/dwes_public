<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta charset="UTF-8">
    <jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center mt-5">
        <h1>Seleccione una opción</h1>
        <button class="btn btn-primary w-100 mt-3"><h2><a style="color: white" href="${pageContext.request.contextPath}/Insert">Insertar cliente</a></h2></button>
        <button class="btn btn-primary w-100 mt-3"><h2><a style="color: white" href="${pageContext.request.contextPath}/Read">Leer cliente</a></h2></button>
        <button class="btn btn-primary w-100 mt-3"><h2><a style="color: white" href="${pageContext.request.contextPath}/Delete">Borrar cliente</a></h2></button>
        <button class="btn btn-primary w-100 mt-3"><h2><a style="color: white" href="${pageContext.request.contextPath}/Update">Modificar cliente</a></h2></button><br>
        <button class="btn btn-primary w-100 mt-3"><a style="color: white" href="${pageContext.request.contextPath}/AreaUsuario">Área de Usuario</a></p></button>
    </div>
</div>
</body>
</html>