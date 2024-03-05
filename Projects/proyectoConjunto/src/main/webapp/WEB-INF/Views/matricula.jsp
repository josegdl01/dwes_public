<%--
  Created by IntelliJ IDEA.
  User: José
  Date: 15/11/2023
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP para mostrar la matriculación</title>
</head>

<jsp:useBean id="matriculaBean" scope="session" class="Modelos.Matricula"></jsp:useBean>
<body>
<h1>Matrícula insertada</h1>
<h2>Nombre <%=matriculaBean.getNombre() %></h2>
<h2>Apellidos <%=matriculaBean.getApellidos() %></h2>
<h2>Email <%=matriculaBean.getEmail() %></h2>
<h2>Curso <%=matriculaBean.getCurso() %></h2>
<h2>Asignaturas</h2>
<ul id="asignaturas">
    <li><h3><%= matriculaBean.getAsignaturas().toString()%></h3></li>
</ul>
</body>
</html>
