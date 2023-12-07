<%-- 
    Document   : formularios
    Created on : 6/12/2023, 01:08:18 PM
    Author     : kevin
--%>

<%@page import="beans.Pago"%>
<%@page import="beans.Prestamo"%>
<%@page import="java.util.List"%>
<%@page import="beans.Ejemplar"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Gestión de Biblioteca</title>
        <style>
            .container {
                padding-top: 20px;
            }
            .form-container {
                background-color: #f7f7f7;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }
            .form-title {
                margin-bottom: 20px;
            }
        </style>
        <base href="${pageContext.request.contextPath}/" />
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


    </head>
    <body>
        <div class="container">
            <% if (session != null && session.getAttribute("usuario") != null) {
                    beans.Usuario usuario = (beans.Usuario) session.getAttribute("usuario");
            %>
            <div class="alert alert-light" role="alert">
                Bienvenido, <%= usuario.getNombre()%> | <a href='logout'>Cerrar Sesión</a>
            </div>
            <% }%>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Gestión de Biblioteca</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"  href="<%=request.getContextPath()%>/prestamo">Realizar Préstamo</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"  href="<%=request.getContextPath()%>/devolucion">Devolver Préstamo</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"  href="<%=request.getContextPath()%>/pago">Pagos</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="card text-center" >

                <div class="card-body">


                    <!-- Formulario "Pago" -->
                    <div id="pagoFormulario" class="form-container">
                        <h3 class="form-title">Registrar Pago</h3>
                        <form action="${pageContext.request.contextPath}/pago" method="post"> 
                            <!-- Tabla de préstamos vigentes -->
                            <div class="table-responsive">
                                <table class="table table-striped" id="pagosTable">
                                    <thead>
                                        <tr>
                                            <th>ID Pago</th>
                                            <th>ID Prestamo</th>
                                            <th>Monto</th>
                                            <th>FechaPago</th>
                                            <!-- Otras columnas según sea necesario -->
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% List<Pago> pagosVigentes = (List<Pago>) request.getAttribute("pagosVigentes");
                                            if (pagosVigentes != null && !pagosVigentes.isEmpty()) {
                                                for (Pago pago : pagosVigentes) {
                                        %>
                                        <tr data-id = "<%= pago.getId()%>">
                                            <td><%= pago.getId()%></td>
                                            <td><%= pago.getIdprestamo()%></td>
                                            <td><%= pago.getMonto()%></td>
                                            <td><%= pago.getFechapago()%></td>
                                        </tr>
                                        <%   }
                                        } else {
                                        %>
                                        <tr><td colspan="5">No hay Pagos disponibles</td></tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>

                            <div class="mb-3">
                                <label for="idpago" class="form-label">Pago a realizar</label>
                                <input type="text" class="form-control" id="idpago" name="idpago"  placeholder="IDPAGO" readonly>
                            </div>
                            <div class="mb-3">
                                <label for="monto" class="form-label">Monto</label>
                                <input type="number" class="form-control" id="monto" name="monto" step="0.01" placeholder="Monto" readonly>
                            </div>
                            <button type="submit" class="btn btn-primary">Pagar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</div>

<script>





    $(document).ready(function () {

        var urlParams = new URLSearchParams(window.location.search);
        var success = urlParams.get('success');

        if (success === 'true') {
            Swal.fire(
                    '¡Éxito!',
                    'El pago ha sido realizado con éxito.',
                    'success'
                    );
        } else if (success === 'false') {
            // Puedes manejar el caso de error si lo necesitas
            Swal.fire(
                    'Error',
                    'Hubo un problema al realizar el préstamo.',
                    'error'
                    );
        }


        $("#searchInput").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#ejemplaresTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });

        $("#ejemplaresTable tr").click(function () {
            var ejemplarId = $(this).data("id");
            var ejemplarTitulo = $(this).find("td:nth-child(2)").text(); // Asumiendo que el título está en la segunda columna

            // Verificar si la opción ya existe en el select
            if ($("#ejemplarSelect option[value='" + ejemplarId + "']").length == 0) {
                // Agregar la nueva opción al select
                $("#ejemplarSelect").append(new Option(ejemplarTitulo, ejemplarId));
            }

            // Seleccionar la nueva opción
            $("#ejemplarSelect").val(ejemplarId);
        });

        $(document).ready(function () {
            $("#pagosTable tbody tr").click(function () {
                var pagoId = $(this).data("id");
                var monto = $(this).find("td:nth-child(3)").text(); // Asumiendo que aquí tienes el monto del pago
                // Otros campos según sea necesario

                // Actualizar los campos del formulario con la información del pago seleccionado
                $("#idpago").val(pagoId);
                $("#monto").val(monto);
            });
        });


    });





</script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>