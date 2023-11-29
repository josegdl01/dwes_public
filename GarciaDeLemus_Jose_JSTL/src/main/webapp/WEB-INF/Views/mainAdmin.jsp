<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 29/11/2023
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headerAdmin.jsp"%>
<html>
<head>
    <title>Página de inicio para Administradores</title>

<%--    .estilo_Tabla_1 {--%>
<%--    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;--%>
<%--    width: 70%;--%>
<%--    border-collapse: collapse;--%>
<%--    }--%>

<%--    .estilo_Tabla_1 td {--%>
<%--    font-size: 1em;--%>
<%--    border: 1px solid #98bf21;--%>
<%--    padding: 4px;--%>
<%--    }--%>

<%--    .estilo_Tabla_1 th {--%>
<%--    border: 1px solid #98bf21;--%>
<%--    font-size: 1.2em;--%>
<%--    padding: 5px;--%>
<%--    background-color: #A7C942;--%>
<%--    color: #ffffff;--%>
<%--    }--%>

<%--    .estilo_Tabla_1 tr td {--%>
<%--    color: #000000;--%>

<%--    background-color: #EAF2D3;--%>
<%--    }--%>
</head>
<body>
<table class="estilo_Tabla_1">
    <thead>
    <th>Código</th>
    <th>Nombre</th>
    <th>Categoría</th>
    <th>Stock</th>
    <th>Precio</th>
    <th>Acción</th>
    </thead>
    <tbody>
    <c:if test="${!sessionScope.productos.isEmpty()}">
        <c:forEach var="producto" items="${productos}">
            <tr>
                <td>${producto.getCodigo()}</td>
                <td>${producto.getNombre()}</td>
                <td>${producto.getCategoria()}</td>
                <td>${producto.getStock()}</td>
                <td>${producto.getPrecio()}</td>
                <td><a href="Update?code=${producto.getCodigo()}">Editar</a></td>
            </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
<img src="/WEB-INF/img/_2_admin_inicio.png">
</body>
</html>
