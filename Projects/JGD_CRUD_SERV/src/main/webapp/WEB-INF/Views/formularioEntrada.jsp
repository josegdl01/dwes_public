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
    <jsp:include page="include/bootstrap.jsp"/>
</head>

<body>
<div class="container mt-5">
    <div class="row justify-content-center mt-5">
        <h1><fmt:message key ="entradaTag"/></h1>
        <form method="post">
            <label for="name" class="form-label"><fmt:message key = "userTag"/></label><input id="name" type="text" name="name" class="form-control"><br><br>
            <label for="pswd" class="form-label"><fmt:message key = "pswdTag"/></label><input id="pswd" type="password" name="pswd" class="form-control"><br><br>
            <a href="${pageContext.request.contextPath}/RegistroServlet"><fmt:message key="linkRegTag"/></a>
            <br><br>
            <button type="submit" name="submit" class="btn btn-primary w-100 mt-3"><fmt:message key = "enterTag"/></button>
        </form>
    </div>
</div>

</body>
</html>
