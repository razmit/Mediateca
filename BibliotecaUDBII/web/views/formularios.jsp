<%-- 
    Document   : formularios
    Created on : 6/12/2023, 01:08:18 PM
    Author     : kevin
--%>

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
            <div class="card text-center">
                <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs">
                        <li class="nav-item">
                            <a class="nav-link active"  id="realizarLink">Realizar Préstamo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link"  id="devolverLink">Devolver Préstamo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link"  id="pagoLink">Registrar Pago</a>
                        </li>
                    </ul>
                </div>
                <div class="card-body">
                    <!-- Formulario "Realizar Prestamo" -->
                    <div id="realizarFormulario" class="form-container" style="display: none;">
                        <h3 class="form-title">Realizar Préstamo</h3>
                        <form action="${pageContext.request.contextPath}/prestamo" method="post">


                            <div class="search-container mb-3">
                                <input type="text" class="form-control" id="searchInput" placeholder="Buscar ejemplares..." title="Escribe un nombre">
                            </div>
                            <div class="mb-3">
                                <label for="ejemplarPrestamo" class="form-label">Ejemplar a prestar</label>
                                <select class="form-select" id="ejemplarSelect" name="idEjemplar" aria-label="Seleccione id Ejemplar">
                                    <!-- Opciones de ejemplar -->
                                </select>
                            </div>


                            <!-- Tabla de ejemplares disponibles -->
                            <div class="table-responsive">
                                <table class="table table-striped" id="ejemplaresTable">
                                    <thead>
                                        <tr>
                                            <th>ID Ejemplar</th>
                                            <th>Título</th>
                                            <th>Autor</th>
                                            <th>Tipo</th>
                                            <th>Ubicación</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% List<Ejemplar> ejemplaresDisponibles = (List<Ejemplar>) request.getAttribute("ejemplaresDisponibles");
                                            if (ejemplaresDisponibles != null && !ejemplaresDisponibles.isEmpty()) {
                                                for (Ejemplar ejemplar : ejemplaresDisponibles) {
                                        %>
                                        <tr data-id = "<%= ejemplar.getId()%>">
                                            <td><%= ejemplar.getId()%></td>
                                            <td><%= ejemplar.getTitulo()%></td>
                                            <td><%= ejemplar.getIdautor()%></td>
                                            <td><%= ejemplar.getTipo()%></td>
                                            <td><%= ejemplar.getUbicacion()%></td>
                                        </tr>
                                        <%   }
                                        } else {
                                        %>
                                        <tr><td colspan="5">No hay ejemplares disponibles</td></tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                            <button type="submit" class="btn btn-primary">Realizar Préstamo</button>
                        </form>
                    </div>

                    <!-- Formulario "Devolver Prestamo" -->
                    <div id="devolverFormulario" class="form-container" style="display: none;">
                        <h3 class="form-title">Devolver Préstamo</h3>
                        <form>
                            <div class="mb-3">
                                <label for="prestamoDevolucion" class="form-label">Id Préstamo</label>
                                <select class="form-select" id="prestamoDevolucion" aria-label="Seleccione Id Préstamo">
                                    <!-- Opciones de préstamo -->
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="estadoDevolucion" class="form-label">Estado de Devolución</label>
                                <select class="form-select" id="estadoDevolucion" aria-label="Estado devolución">
                                    <option value="En tiempo">En tiempo</option>
                                    <option value="Atrasado">Atrasado</option>
                                    <!-- Más estados si son necesarios -->
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="comentario" class="form-label">Comentarios</label>
                                <textarea class="form-control" id="comentario" name="comentario" rows="4" placeholder="Escribe tu comentario aquí..."></textarea>
                            </div>
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </form>
                    </div>

                    <!-- Formulario "Pago" -->
                    <div id="pagoFormulario" class="form-container" style="display: none;">
                        <h3 class="form-title">Registrar Pago</h3>
                        <form>
                            <div class="mb-3">
                                <label for="usuarioPago" class="form-label">Usuario</label>
                                <select class="form-select" id="usuarioPago" aria-label="Seleccione id usuario">
                                    <!-- Opciones de usuario -->
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="monto" class="form-label">Monto</label>
                                <input type="number" class="form-control" id="monto" name="monto" step="0.01" placeholder="Monto">
                            </div>
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script>
            window.onload = function () {
                document.getElementById("realizarLink").addEventListener("click", function () {
                    document.getElementById("realizarFormulario").style.display = "block";
                    document.getElementById("devolverFormulario").style.display = "none";
                    document.getElementById("pagoFormulario").style.display = "none";
                });

                document.getElementById("devolverLink").addEventListener("click", function () {
                    document.getElementById("realizarFormulario").style.display = "none";
                    document.getElementById("devolverFormulario").style.display = "block";
                    document.getElementById("pagoFormulario").style.display = "none";
                });

                document.getElementById("pagoLink").addEventListener("click", function () {
                    document.getElementById("realizarFormulario").style.display = "none";
                    document.getElementById("devolverFormulario").style.display = "none";
                    document.getElementById("pagoFormulario").style.display = "block";
                });
            };

            $(document).ready(function () {

                var urlParams = new URLSearchParams(window.location.search);
                var success = urlParams.get('success');

                if (success === 'true') {
                    Swal.fire(
                            '¡Éxito!',
                            'El préstamo ha sido realizado con éxito.',
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


            });



        </script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>