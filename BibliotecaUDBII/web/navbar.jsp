<%-- 
    Document   : navbar
    Created on : Dec 4, 2023, 4:24:53 PM
    Author     : PC
--%>

<div class="navbar">
    <a href="index.jsp">Inicio</a>
    <% if (session != null && session.getAttribute("usuario") != null) {
            beans.Usuario usuario = (beans.Usuario) session.getAttribute("usuario");
            out.println("Bienvenido, " + usuario.getNombre());
            out.println("<a href='logout'>Cerrar Sesión</a>");
        } else {
            out.println("<a href='views/login.jsp'>Iniciar Sesión</a>");
        }%>
</div>
