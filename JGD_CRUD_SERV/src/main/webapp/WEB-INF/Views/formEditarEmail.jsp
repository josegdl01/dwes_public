<%--
  Created by IntelliJ IDEA.
  User: José
  Date: 03/12/2023
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Área del usuario para cambiar contraseña, email o nombre de usuario</title>
</head>
<body>
<h1>Seleccione una opción</h1>
<form method="post">

    <label>
        <input name="newEmail" type="text" placeholder="${user.getEmail()}">
    </label><br><br>

    <button type="submit">Enviar</button><br>
    <button><p><a href="${pageContext.request.contextPath}/AreaUsuario">Volver al area de Usuario</a></p></button>

</form>
</body>
</html>
