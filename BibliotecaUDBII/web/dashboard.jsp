<%-- 
    Document   : dashboard
    Created on : 12-06-2023, 09:19:07 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<%
    request.setAttribute("title", "Inicio");
%>

 <%@ include file="views/components/header.jsp" %>
 
 <%@ include file="views/components/navbar.jsp" %>
 
 <%@ include file="views/components/sidebar.jsp" %>
 
 <!--contenido de-->
   
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Pagina Inicial</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Inicio</a></li>
              <li class="breadcrumb-item active">Actual</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

    </section>
  
 <%@ include file="views/components/footer.jsp" %>