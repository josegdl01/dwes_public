<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 16/11/2023
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <nav>
        <a href="<%=request.getContextPath() + "/VolverServlet"%>">Volver</a>
        <a href="<%=request.getContextPath() + "/LogoutServlet"%>">Salir</a>
        <br>
        <%
            if (request.getSession().getAttribute("nombreUsuario") != null && request.getSession().getAttribute("inicioSesion") != null) {


        %>
        <p>Usuario: <%=request.getSession().getAttribute("nombreUsuario")%> Inicio de sesión: <%=request.getSession().getAttribute("inicioSesion")%>
        </p>
        <%
            }
        %>
    </nav>

</header>
</body>
</html>
