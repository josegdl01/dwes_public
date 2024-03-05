<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 16/11/2023
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Ventana que muestra los datos de la reserva</title>
</head>

<jsp:useBean id="reservaBean" scope="session" class="Model.ReservaBean"/>
<body>
<h1>RESERVA CONFIRMADA</h1>
<h2>Fecha de inicio: <%= reservaBean.getFechaInicio()%>
</h2>
<h2>Fecha de finalización: <%= reservaBean.getFechaFin()%>
</h2>
<h2>Número de Personas: <%= reservaBean.getNumPersonas()%>
</h2>
<h2>Servicios contratados: </h2>
<ul id="servicios">
    <%
        for (String servicio : reservaBean.getServicios()) {
    %>
    <li><h3><%= servicio %></h3></li>
    <% } %>
</ul>
</body>
</html>
