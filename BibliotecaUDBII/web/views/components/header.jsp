<%-- 
    Document   : header
    Created on : 12-06-2023, 09:21:07 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%
        // Obtener el atributo de solicitud
        String title = (String) request.getAttribute("title");
    %>
  <title><%= title %> | Biblioteca</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
    
    <div class="wrapper">