<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 29/11/2023
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headerUser.jsp"%>
<html>
<head>
    <title>Buscador de Oficinas</title>
</head>
<body>
<h1>Buscador de oficinas</h1>
    <form method="post">
        <select name="oficinas">
            <option value="1">San Francisco</option>
            <option value="2">Boston</option>
            <option value="3">NYC</option>
            <option value="4">Paris</option>
            <option value="5">Tokyo</option>
            <option value="6">Sydney</option>
            <option value="7">London</option>
        </select><br><br>
        <button type="submit">Buscar</button>
    </form>

    <c:if test="${sessionScope.oficina != null}">
        <h2>Codigo oficina: ${oficina.getCodigo()}</h2>
        <h2>Ciudad: ${oficina.getCiudad()}</h2>
        <h2>Teléfono: ${oficina.getTlf()}</h2>
        <h2>Dirección 1: ${oficina.getDireccion1()}</h2>
        <h2>Dirección 2: ${oficina.getDireccion2()}</h2>
        <h2>Estado: ${oficina.getEstado()}</h2>
        <h2>País: ${oficina.getPais()}</h2>
        <h2>Código Postal: ${oficina.getCodigoPostal()}</h2>
        <h2>Territorio: ${oficina.getTerritorio()}</h2>
    </c:if>
<img src="/WEB-INF/img/_1_Oficinas.png">
</body>
</html>
