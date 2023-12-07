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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Iniciar Sesión | Biblioteca</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/fontawesome-free/css/all.min.css">
        <!-- icheck bootstrap -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/css/adminlte.min.css">
        <base href="${pageContext.request.contextPath}/" />
    </head>
    <body class="hold-transition login-page">

<!--        <div class="navbar">
            <a href="index.jsp">Inicio</a>
            <a href="views/login.jsp">Iniciar Sesión</a>

        </div>-->
          <!-- /.login-logo -->
        <div class="card card-outline card-primary mt-5">
          <div class="card-header text-center">
            <a href="#" class="h1"><b>Iniciar</b> Sesion</a>
          </div>
          <div class="card-body">
           
            <% if (request.getAttribute("mensaje") != null) {%>
                <div class="callout callout-danger">
                  <h5><%= request.getAttribute("mensaje")%></h5>
                </div>
            <% }%>
        
            <form action="login" method="post">
              <div class="input-group mb-3">
                <input type="email" id="correo" name="correo" required class="form-control" placeholder="Correo Electrónico">
                <div class="input-group-append">
                  <div class="input-group-text">
                    <span class="fas fa-envelope"></span>
                  </div>
                </div>
              </div>
              <div class="input-group mb-3">
                <input type="password" id="contrasena" name="contrasena" required class="form-control" placeholder="Contraseña">
                <div class="input-group-append">
                  <div class="input-group-text">
                    <span class="fas fa-lock"></span>
                  </div>
                </div>
              </div>
              <div class="row">
                
                <div class="col-12 col-md-12 col-lg-12">
                  <button type="submit" class="btn btn-primary btn-block">Iniciar Sesión</button>
                </div> 
              </div>
            </form>

          </div>
        </div>
      </div>
        
        <!-- jQuery -->
        <script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/assets/dist/js/adminlte.min.js"></script>
    </body>
</html>
