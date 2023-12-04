<%-- 
    Document   : login
    Created on : Dec 4, 2023, 2:38:46 PM
    Author     : PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Iniciar Sesión</title>
        <!-- Añadir enlaces a CSS si es necesario -->
        <style>
            /* Estilos básicos para la barra de navegación */
            .navbar {
                overflow: hidden;
                background-color: #333;
            }

            .navbar a {
                float: left;
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            .navbar a:hover {
                background-color: #ddd;
                color: black;
            }
        </style>
        <base href="${pageContext.request.contextPath}/" />
    </head>
    <body>

        <div class="navbar">
            <a href="index.jsp">Inicio</a>
            <a href="views/login.jsp">Iniciar Sesión</a>

        </div>
        <h2>Iniciar Sesión</h2>

        <% if (request.getAttribute("mensaje") != null) {%>
        <p style="color:red;"><%= request.getAttribute("mensaje")%></p>
        <% }%>

        <form action="login" method="post">
            <div>
                <label for="correo">Correo Electrónico:</label>
                <input type="email" id="correo" name="correo" required>
            </div>
            <div>
                <label for="contrasena">Contraseña:</label>
                <input type="password" id="contrasena" name="contrasena" required>
            </div>
            <div>
                <button type="submit">Iniciar Sesión</button>
            </div>
        </form>

    </body>
</html>
