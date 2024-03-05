<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<fmt:setBundle basename="interface" />
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<c:if test="${sessionScope.LOGUEADO && sessionScope.LOGUEADO != null}">
    <form method="get">
        <button name="boton_salir" value="Salir" formaction="${pageContext.request.contexPath}/LogoutServlet">Salir
        </button>
    </form>
</c:if>
<c:if test="${!sessionScope.LOGUEADO && sessionScope.LOGUEADO == null}">
    <form method="post">
        <button name="boton_entrar" value="Entrar"><fmt:message key="botonEntrarTag" /></button>
    </form>
</c:if>
</body>
</html>