<%-- 
    Document   : index
    Created on : Dec 4, 2023, 3:46:38 PM
    Author     : PC
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página Principal</title>
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

    <%@ include file="navbar.jsp" %>
    
    <h1>Bienvenido a Nuestra Aplicación</h1>
    <p>Esta es la página principal de nuestra aplicación.</p>

    <!-- Resto del contenido de la página -->

</body>
</html>

