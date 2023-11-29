<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 29/11/2023
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <nav>
        <a href="${pageContext.request.contextPath}/UserMain">Inicio</a>
        <a href="${pageContext.request.contextPath}/Oficinas">Buscar Oficinas</a>
        Está usted logueado como ${usuario.getFirstName()} ${usuario.getLastName()}
        <a href="${pageContext.request.contextPath}/LogoutServlet">Salir</a>
    </nav>

</header>
</body>
</html>
