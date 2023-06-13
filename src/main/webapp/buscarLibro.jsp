<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 13-06-2023
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main>
    <section>
        <article class="b-form">
            <form action="" method="post">
                <input placeholder="Titulo del libro" name="titulo" type="text">
                <select name="categoria">
                    <option value="0">Categoria</option>
                    <c:forEach items="${categorias}" var="categoria">
                        <option value="${categoria.getId()}">${categoria.getNombreCategoria()}</option>
                    </c:forEach>
                </select>
                <button type="submit">Buscar</button>
            </form>
        </article>
    </section>
    <section class="r-busqueda">
        <table>
            <tr>
                <th>ID</th>
                <th>Titulo libro</th>
                <th>Categoria</th>
                <th>Fecha de publicacion</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach items="${libros}" var="libro">
                <tr>
                    <td><c:out value="${libro.getId()}"></c:out></td>
                    <td><c:out value="${libro.getNombre()}"></c:out> </td>
                    <td><c:out value="${libro.getCategoria()}"></c:out> </td>
                    <c:forEach items="${categorias}" var="categoria">
                        <td>
                            <c:choose>
                                <c:when test="${libro.categoria() eq categoria.id()}">
                                    <c:out value="${categoria.nombreCategoria()}"/>
                                </c:when>
                            </c:choose>
                        </td>
                    </c:forEach>
                    <td><c:out value="${libro.getDate()}"></c:out> </td>
                    <td>
                        <a href="eliminarLibro?id=${libro.getId()}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </section>

</main>
</body>
</html>
