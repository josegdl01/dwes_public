<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: DAW_M
  Date: 29/11/2023
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headerAdmin.jsp"%>
<html>
<head>
    <title>Editar Producto</title>
</head>
<body>
<h1>Editar Producto</h1>
    <form method="post">
        <label for="codigoProducto">Codigo</label><input readonly id="codigoProducto" name="codigo" value="${producto.getCodigo()}"><br>
        <label for="nombreProducto">Nombre</label><input id="nombreProducto" name="nombre" value="${producto.getNombre()}"><br>
        <label for="categoriaProducto">Categoria</label>
        <select id="categoriaProducto" name="categoria">
            <c:forEach var="categoria" items="${sessionScope.categorias}">
                <c:if test="${categoria.equals(producto.getCategoria())}">
                <option selected value= "${categoria}">${categoria}</option>
                </c:if>
                <c:if test="${!categoria.equals(producto.getCategoria())}">
                    <option value= "${categoria}">${categoria}</option>
                </c:if>
            </c:forEach>
        </select><br>
        <label for="stockProducto">Stock</label><input id="stockProducto" name="stock" value="${producto.getStock()}"><br>
        <label for="precioProducto">Precio</label><input id="precioProducto" name="precio" value="${producto.getPrecio()}"><br>
        <button type="submit">Confirmar</button>
    </form>
<img src="/WEB-INF/img/_3_admin_edit.png">
</body>
</html>
