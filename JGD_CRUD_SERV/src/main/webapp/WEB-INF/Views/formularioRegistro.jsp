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
    <meta charset="UTF-8">
    <jsp:include page="include/bootstrap.jsp"/>
</head>

<body>

<div class="container mt-5">
    <div class="row justify-content-center mt-5">
        <h1><fmt:message key = "regTitleTag"/></h1>
        <br>
        <form method="post">
            <label class="form-label" for="userReg"><fmt:message key = "userTag"/></label><input class="form-control" id="userReg" type="text" name="userReg"><br><br>
            <label class="form-label" for="emailReg"><fmt:message key = "emailTag"/></label><input class="form-control" id="emailReg" type="text" name="emailReg"><br><br>
            <label class="form-label" for="pswdReg"><fmt:message key = "pswdTag"/></label><input class="form-control" id="pswdReg" type="password" name="pswdReg"><br><br>
            <br><br>
            <button class="btn btn-primary w-100 mt-3" type="submit" name="submit"><fmt:message key = "registerTag"/></button>
        </form>
    </div>
</div>
</body>
</html>