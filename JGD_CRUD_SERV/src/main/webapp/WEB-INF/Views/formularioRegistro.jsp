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
    <label for="userReg"><fmt:message key = "userTag"/></label><input id="userReg" type="text" name="userReg"><br><br>
    <label for="emailReg"><fmt:message key = "emailTag"/></label><input id="emailReg" type="text" name="emailReg"><br><br>
    <label for="pswdReg"><fmt:message key = "pswdTag"/></label><input id="pswdReg" type="password" name="pswdReg"><br><br>
    <br><br>
    <button type="submit" name="submit"><fmt:message key = "registerTag"/></button>
</form>
</body>
</html>