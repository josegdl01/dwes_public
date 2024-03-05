<%--
  Created by IntelliJ IDEA.
  User: jgdur
  Date: 08/11/2023
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${matriculaBean.nombre}</h2>
<h2>${matriculaBean.apellidos}</h2>
<h2>${matriculaBean.email}</h2>
<h2>${matriculaBean.curso}</h2>
<c:if test="${matriculaBean.asignaturas == null}">
    <h3>No se ha seleccionado ninguna asignatura</h3>
</c:if>
<c:if test="${!matriculaBean.asignaturas == null}">
    <ul>
        <c:forEach var="asig" items="${matriculaBean.asignaturas}">
            <li>
                <c:out value="${asig}"></c:out>
            </li>
        </c:forEach>
    </ul>

</c:if>
</body>
</html>
