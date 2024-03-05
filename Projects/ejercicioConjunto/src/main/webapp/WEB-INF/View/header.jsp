<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 09/11/2023
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <header>
        <nav>
            <a href="<%=request.getContextPath()%>">Volver</a>
            <a href="<%=request.getContextPath() + "/LogoutServlet"%>">Salir</a>
        </nav>

    </header>
</body>
</html>
