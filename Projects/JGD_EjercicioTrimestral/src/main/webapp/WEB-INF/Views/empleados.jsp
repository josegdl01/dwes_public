<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 14/12/2023
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Empleados</title>
</head>
<body>
<h1>Empleados</h1>
<button><a href="${requestScope.pageContext.contextPath}/AddEmpleado">Añadir Empleado</a></button>
<table>
    <thead>
    <th>Número</th>
    <th>Apellidos</th>
    <th>Nombre</th>
    <th>Puesto</th>
    <th>Oficina</th>
    <th>Jefe</th>
    </thead>
    <c:forEach var="emp" items="${sessionScope.empleados}">
        <tr>
            <td>${emp.getId()}</td>
            <td>${emp.getApellidos()}</td>
            <td>${emp.getNombre()}</td>
            <td>${emp.getPuesto()}</td>
            <td>${emp.getOficina()}</td>
            <td>${emp.getJefe()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
