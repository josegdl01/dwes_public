<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 16/11/2023
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Formulario sobre los detalles de la reserva</title>
</head>
<body>
<h1>DATOS DE LA RESERVA</h1>
<form method="post">
    <label>
        Fecha de Inicio
        <input name="inicioReserva" type="date">
    </label>
    <br>
    <label>
        Fecha de Fin
        <input name="finReserva" type="date">
    </label>
    <br>
    <label>
        Número de Personas
        <input name="numPersonas" type="number">
    </label>
    <br>
    <h2>SERVICIOS</h2>

    <label>
        Wifi
        <input type="checkbox" name="Wifi" value="Wifi">
    </label>
    <label>
        Toallas
        <input type="checkbox" name="Toallas" value="Toallas">
    </label>
    <label>
        Desayuno
        <input type="checkbox" name="Desayuno" value="Desayuno">
    </label>
    <br>
    <label>
        Limpieza
        <input type="checkbox" name="Limpieza" value="Limpieza">
    </label>
    <label>
        Ruta guiada
        <input type="checkbox" name="Ruta guiada" value="Ruta guiada">
    </label>
    <label>
        Sauna
        <input type="checkbox" name="Sauna" value="Sauna">
    </label>
    <br>
    <input type="submit" value="RESERVAR">
</form>

</body>
</html>
