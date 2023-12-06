<%-- 
    Document   : formularios
    Created on : 6/12/2023, 01:08:18 PM
    Author     : kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card text-center">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="true" href="#" id="realizarLink">Realizar Prestamo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" id="devolverLink">Devolver Prestamo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" id="pagoLink">Pago</a>
                    </li>
                </ul>
            </div>
            <div class="card-body">
                <div id="realizarFormulario" style="display: none;">
                    <!-- Formulario "Realizar Prestamo" -->
                    <center>
                        <div style="max-width: 400px;">
                            <form>
                                <div style="text-align: center;">
                                    <select class="form-select" aria-label="Default select example">
                                        <option selected> Seleccione id usuario</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                    <br>
                                    <select class="form-select" aria-label="Default select example">
                                        <option selected> Seleccione id Ejemplar</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                    <br>
                                    <label for="fechaPrestamo">Fecha prestamo</label>
                                    <br>
                                    <input type="date" class="form-control" id="fechaPrestamo" name="fechaPrestamo">
                                </div>
                                <br>
                                <label for="fechaDevolucion">Fecha Devolucion</label>
                                <br>
                                <input type="date" class="form-control" id="fechaDevolucion" name="fechaDevolucion">
                                </div>
                                <br>
                                <button type="submit" class="btn btn-primary">Enviar</button>
                        </div>
                        </form>
                </div>
                </center>
                <div id="devolverFormulario" style="display: none;">
                    <!-- Formulario "Devolver Prestamo" -->
                    <center>
                        <div style="max-width: 400px;">
                            <form>
                                <div style="text-align: center;">
                                    <div style="text-align: center;">
                                        <select class="form-select" aria-label="Default select example">
                                            <option selected> Seleccione Id Prestamo</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                        <br>
                                        <label for="fechaDevolucion">Fecha devolucion</label>
                                        <input type="date" class="form-control" id="fechadevolucion" name="fechadevolucion">

                                        <br>
                                        <select class="form-select" aria-label="Default select example">
                                            <option selected> Estado devolucion</option>
                                            <option value="1">Tiempo</option>
                                            <option value="2">Atrasado</option>
                                            <option value="3">Perdido</option>
                                        </select>
                                        <br>
                                        <div class="mb-3">
                                           <label for="comentario">Comentarios</label>
                                           <textarea class="form-control" id="comentario" name="comentario" rows="4" placeholder="Escribe tu Comentario aquí..."></textarea>
                                        </div>
                                        <br>
                                        <button type="submit" class="btn btn-primary">Enviar</button>
                                    </div>
                            </form>
                        </div>
                    </center>
                </div>

                <div id="pagoFormulario" style="display: none;">
                    <!-- Formulario "Pago" -->
                    <center>
                        <div style="max-width: 400px;">
                            <form>
                                <div style="text-align: center;">
                                     <select class="form-select" aria-label="seleccione id usuario">
                                        <option selected> Seleccione id usuario</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                     <label for="numeroDecimal">monto</label>
                                     <input type="number" class="form-control" id="numeroDecimal" name="numeroDecimal" step="0.01" placeholder="monto">
                                    <br>
                                    <div class="form-group">
                                        <label for="fechaPago">Fecha de Pago</label>
                                        <input type="date" class="form-control" id="fechaPago" name="fechaPago">
                                    </div>
                                    <br>
                                      <select class="form-select" aria-label="Default select example">
                                            <option selected> Seleccione Id Prestamo</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                    <br>
                                    <select class="form-select" aria-label="Default select example">
                                        <option selected> Seleccione id Ejemplar</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                    </select>
                                    
                                    <br>
                                    
                                    
                                    <button type="submit" class="btn btn-primary">Enviar</button>
                                </div>
                            </form>
                        </div>
                    </center>
                </div>
            </div>
        </div>
    </div>



    <script>
      window.onload = function() {
        document.getElementById("realizarLink").addEventListener("click", function() {
          // Oculta el formulario de "Devolver Prestamo" y "Pago", y muestra el de "Realizar Prestamo"
          document.getElementById("realizarFormulario").style.display = "block";
          document.getElementById("devolverFormulario").style.display = "none";
          document.getElementById("pagoFormulario").style.display = "none";
        });

        document.getElementById("devolverLink").addEventListener("click", function () {
                // Oculta el formulario de "Realizar Prestamo" y "Pago", y muestra el de "Devolver Prestamo"
                document.getElementById("realizarFormulario").style.display = "none";
                document.getElementById("devolverFormulario").style.display = "block";
                document.getElementById("pagoFormulario").style.display = "none";
            });

            document.getElementById("pagoLink").addEventListener("click", function () {
                // Oculta el formulario de "Realizar Prestamo" y "Devolver Prestamo", y muestra el de "Pago"
                document.getElementById("realizarFormulario").style.display = "none";
                document.getElementById("devolverFormulario").style.display = "none";
                document.getElementById("pagoFormulario").style.display = "block";
            });
        };
    </script>








    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>

