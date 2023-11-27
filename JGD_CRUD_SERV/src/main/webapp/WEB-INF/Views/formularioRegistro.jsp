<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setBundle basename="interface" />
<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 02/11/2023
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de registro</title>
</head>

<body>
<h1><fmt:message key = "regTitleTag"/></h1>
<br>
<form method="post">
    <label for="user"><fmt:message key = "userTag"/></label><input id="user" type="text" name="name"><br><br>
    <label for="pswd"><fmt:message key = "emailTag"/></label><input id="email" type="password" name="pswd"><br><br>
    <label for="pswd"><fmt:message key = "pswdTag"/></label><input id="pswd" type="password" name="pswd"><br><br>
    <br><br>
    <button type="submit" name="submit"><fmt:message key = "registerTag"/></button>
</form>
</body>
</html>