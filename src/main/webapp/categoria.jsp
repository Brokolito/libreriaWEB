<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 06-06-2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar categoria</title>
</head>
<body>
    <main>
        <article>
            <h1 class="f-title">Agregar categoria</h1>
            <section class="f-categorias">
                <form action="registrarCategoria" method="post">
                    <input name="nombre" placeholder="nombre categoria" type="text">
                    <button type="submit">Agregar categoria nueva</button>
                </form>
                <%
                    String mensaje = (String) request.getAttribute("status");
                    if (mensaje != null && !mensaje.isEmpty()) {
                %>
                <h2><%= mensaje %></h2>
                <%
                    }
                %>
            </section>
            <a href="index.jsp">Volver</a>
        </article>
    </main>
</body>
</html>
