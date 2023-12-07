/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Devolucion;
import beans.Prestamo;
import beans.Usuario;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelosDAO.DevolucionDAO;
import modelosDAO.PrestamoDAO;
import util.SessionUtils;

/**
 *
 * @author PC
 */
@WebServlet("/devolucion")
public class DevolucionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getId();

        DevolucionDAO devolucionDAO = new DevolucionDAO();
        List<Prestamo> prestamosVigentes = devolucionDAO.obtenerPrestamosVigentesPorUsuario(idUsuario);

        request.setAttribute("prestamosVigentes", prestamosVigentes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/devolucion.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idprestamo = request.getParameter("idPrestamo");
        String estadoDevolucion = request.getParameter("estadoDevolucion");
        String comentario = request.getParameter("comentario");
        int idPrestamoInt = Integer.parseInt(idprestamo);
        HttpSession session = request.getSession(false); // Obtener la sesión actual sin crear una nueva
        Usuario usuario = SessionUtils.getUsuarioFromSession(session);
        int usuarioId = usuario.getId();

        // Lógica para devolver el préstamo
        Devolucion devolucion = new Devolucion();
        LocalDate fechaActual = LocalDate.now();
        Date fechaDevolucion = Date.valueOf(fechaActual);

        // Establecer los datos de la devolución
        devolucion.setIdprestamo(idPrestamoInt);
        devolucion.setFechadevolucion(fechaDevolucion);
        devolucion.setEstadodevolucion(estadoDevolucion);
        devolucion.setComentarios(comentario);

        if (devolucion != null) {
            DevolucionDAO devolucionDAO = new DevolucionDAO();
            boolean resultado = devolucionDAO.guardarDevolucion(devolucion);

            if (resultado) {
                response.sendRedirect(request.getContextPath() + "/devolucion?success=true");
            } else {
                String mensaje = "No se pudo realizar el prestamo";
                request.setAttribute("mensaje", mensaje);
            }
        }

    }
}
