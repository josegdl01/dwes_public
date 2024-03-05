<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%
    if (!session.isNew() && (boolean) session.getAttribute("LOGUEADO")) {
%>
<form method="get">
    <button name="boton_salir" value="Salir" formaction="<%=request.getContextPath() + "/LogoutServlet"%>">Salir</button>
</form>

<%
} else {%>
<form method="post">
    <button name="boton_entrar" value="Entrar">Entrar</button>
</form>
<%
    }
%>
</body>
</html>