<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post">
    <label>
        Usuario
        <input name="usuario" type="text">
    </label>
    <br>
    <label>
        Password
        <input name="password" type="password">
    </label>
    <br>
    <label>
        Confirmar Password
        <input name="passwordConfirm" type="password">
    </label>
    <br>
    <label>
        Email
        <input name="email" type="email">
    </label>
    <br>
    <input type="submit" value="botonEnviar">
</form>
</body>
</html>