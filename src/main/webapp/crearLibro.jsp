<%@ page import="java.util.ArrayList" %>
<%@ page import="com.registro.registro.model.Categoria" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 06-06-2023
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro Libro</title>
    <link type="text/css" href="styles.css">
</head>
<body>
    <main>
        <article>
            <section class="formulario">
                <form action="crearLibro" method="post">
                    <input placeholder="Nombre del libro" name="titulo" type=text">
                    <select name="categoria">
                        <option value="0">Categoria</option>
                        <c:forEach items="${categorias}" var="categoria">
                            <option value="${categoria.getId()}">${categoria.getNombreCategoria()}</option>
                        </c:forEach>
                    </select>
                    <input type="date" name="fecha">
                    <button type="submit">Registrar libro</button>
                </form>
                <a href="index.jsp">Volver</a>
            </section>
        </article>
    </main>
</body>
</html>
