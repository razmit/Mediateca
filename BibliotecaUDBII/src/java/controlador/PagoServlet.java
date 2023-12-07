/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Devolucion;
import beans.Pago;
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
import modelosDAO.PagoDAO;
import util.SessionUtils;

/**
 *
 * @author PC
 */
@WebServlet("/pago")
public class PagoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getId();

        PagoDAO pagoDAO = new PagoDAO();
        List<Pago> pagosVigentes = pagoDAO.obtenerPagosVigentesPorUsuario(idUsuario);

        request.setAttribute("pagosVigentes", pagosVigentes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/pagos.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idpago = request.getParameter("idpago");
        int idPago = Integer.parseInt(idpago);
        HttpSession session = request.getSession(false); // Obtener la sesión actual sin crear una nueva
        Usuario usuario = SessionUtils.getUsuarioFromSession(session);
        int usuarioId = usuario.getId();

        // Lógica para devolver el préstamo
        Pago pago = new Pago();
        LocalDate fechaActual = LocalDate.now();
        Date fechaDevolucion = Date.valueOf(fechaActual);

        // Establecer los datos de la devolución
        pago.setId(idPago);
        pago.setIdusuario(usuarioId);
        pago.setFechapago(fechaDevolucion);
        
        
        if (pago != null) {
            PagoDAO pagoDAO = new PagoDAO();
            boolean resultado = pagoDAO.actualizarPago(pago);

            if (resultado) {
                response.sendRedirect(request.getContextPath() + "/pago?success=true");
            } else {
                String mensaje = "No se pudo realizar el pago";
                request.setAttribute("mensaje", mensaje);
            }
        }

    }

}
