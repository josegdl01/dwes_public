<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 30/10/2023
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Página resultante de insertar un Cliente</title>
    <meta charset="utf-8">
    <jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center mt-5">
        <c:if test="${sessionScope.customerInsert != null}">
            <h1>Datos recibidos:</h1>
            <h2>Customer's ID:
                    ${customerInsert.cusId}
            </h2>
            <h2>Customer's Tax Code:I ${customerInsert.cusTaxCode}
            </h2>
            <h2>Customer's Bus Name: ${customerInsert.cusBusName}
            </h2>
            <h2>Customer's Address: ${customerInsert.cusAddress}
            </h2>
            <h2>Customer's Phone: ${customerInsert.cusPhone}
            </h2>
        </c:if>
        <c:if test="${sessionScope.customerInsert == null}">
            <h1>Este usuario ya se haya en la base de datos</h1>
        </c:if>
        <br>
        <p><a href="${pageContext.request.contextPath}/Menu">Volver al menú</a></p>
    </div>
</div>
</body>
</html>