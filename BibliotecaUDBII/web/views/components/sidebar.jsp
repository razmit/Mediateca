<%-- 
    Document   : sidebar
    Created on : 12-06-2023, 09:21:26 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="../../index3.html" class="brand-link text-center">
      <span class="brand-text font-weight-light h3">Biblioteca</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="${pageContext.request.contextPath}/assets/dist/img/user-default.png" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <% if (session != null && session.getAttribute("usuario") != null) {
            beans.Usuario usuario = (beans.Usuario) session.getAttribute("usuario");
            out.println(" <a href='#' class='d-block'>"+usuario.getNombre()+"</a>");
            }
          %>
         
        </div>
      </div>
 
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
         <li class="nav-item">
              <a href="${pageContext.request.contextPath}/dashboard.jsp" class="nav-link"> <i class="nav-icon fas fa-home"></i>  <p>Inicio</p> </a>
          </li>
          
           <li class="nav-item">
              <a href="${pageContext.request.contextPath}/views/test.jsp" class="nav-link"> <i class="nav-icon fas fa-power-off"></i>  <p>Test</p> </a>
          </li>
        
           <li class="nav-item">
              <a href="logout" class="nav-link"> <i class="nav-icon fas fa-power-off"></i>  <p>Cerrar Sesión</p> </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
 
  <div class="content-wrapper">