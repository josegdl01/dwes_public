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
    <title>Index del proyecto con un login</title>
</head>

<body>
<h1><fmt:message key ="entradaTag"/></h1>
<br>
<form method="post">
    <label for="name"><fmt:message key = "userTag"/></label><input id="name" type="text" name="name"><br><br>
    <label for="pswd"><fmt:message key = "pswdTag"/></label><input id="pswd" type="password" name="pswd"><br><br>
    <a href="${pageContext.request.contextPath}/Registro"><fmt:message key="linkRegTag"/></a>
    <br><br>
    <button type="submit" name="submit"><fmt:message key = "enterTag"/></button>
</form>
</body>
</html>
