<%--
  Created by IntelliJ IDEA.
  User: José
  Date: 03/12/2023
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Área del usuario para cambiar contraseña, email o nombre de usuario</title>
    <meta charset="UTF-8">
    <jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center mt-5">
        <h1>Cambio de Contraseña</h1>
        <form method="post">
            <label class="form-label">
                <input class="form-control" name="oldPass" type="password" placeholder="Contraseña actual">
            </label><br><br>

            <label class="form-label">
                <input class="form-control" name="newPass" type="password" placeholder="Contraseña nueva">
            </label><br><br>

            <label class="form-label">
                <input class="form-control" name="confirmPass" type="password" placeholder="Confirmación">
            </label><br><br>

            <button class="btn btn-primary w-100 mt-3" type="submit">Enviar</button>
            <br>

            <button class="btn btn-primary w-100 mt-3"><a href="${pageContext.request.contextPath}/AreaUsuario">Volver
                al area de Usuario</a>
            </button>
        </form>
    </div>
</div>
</body>
</html>
