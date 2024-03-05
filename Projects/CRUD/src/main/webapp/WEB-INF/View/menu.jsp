<%--
  Created by IntelliJ IDEA.
  User: José
  Date: 19/11/2023
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu para escoger la acción a realizar</title>
</head>
<body>
<h1>"Menú de inicio de la app CRUD"</h1>
<br/>
<ul>
    <li><h2><a href="<%=request.getContextPath() + "/ReadServlet"%>">Leer Cliente</a></h2></li>
    <li><h2><a href="<%=request.getContextPath() + "/InsertServlet"%>">Insertar Cliente</a></h2></li>
    <li><h2><a href="<%=request.getContextPath() + "/DeleteServlet"%>">Borrar Cliente</a></h2></li>
    <li><h2><a href="<%=request.getContextPath() + "/UpdateServlet"%>">Editar Cliente</a></h2></li>
</ul>
</body>
</html>
