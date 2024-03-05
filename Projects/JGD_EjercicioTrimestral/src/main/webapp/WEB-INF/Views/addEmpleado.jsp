<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 14/12/2023
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario para añadir un Empleado</title>
</head>
<body>
    <form method="post">
        <label for="empId">Número de Empleado</label>
        <input type="number" id="empId" name="empId"><br>

        <label for="empApellidos">Apellidos</label>
        <input type="text" id="empApellidos" name="empApellidos"><br>

        <label for="empNombre">Nombre</label>
        <input type="text" id="empNombre" name="empNombre"><br>

        <label for="empExt">Extensión</label>
        <input type="text" id="empExt" name="empExt"><br>

        <label for="empEmail">Email</label>
        <input type="text" id="empEmail" name="empEmail"><br>

        <label for="empPuesto">Puesto</label>
        <input type="text" id="empPuesto" name="empPuesto"><br>

        <label for="empOficina">Oficina</label>
        <select id="empOficina" name="empOficina">
            <c:forEach var="oficina" items="${sessionScope.oficinas}">
                    <option value="${oficina.getCodigo()}">${oficina.getCiudad()}</option>
            </c:forEach>
        </select><br>
        <label for="empJefe">Jefe</label>
        <select id="empJefe" name="empJefe">
            <c:forEach var="jefe" items="${sessionScope.jefes}">
                <option value="${jefe.getId()}">${jefe.getNombre()}</option>
            </c:forEach>
        </select><br>
        <button type="submit">Enviar</button>
    </form>
</body>
</html>
