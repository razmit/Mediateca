/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Ejemplar;
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
import modelosDAO.PrestamoDAO;
import util.SessionUtils;

/**
 *
 * @author PC
 */
@WebServlet("/prestamo")
public class PrestamoServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrestamoDAO ejemplarDAO = new PrestamoDAO();
        List<Ejemplar> ejemplaresDisponibles = ejemplarDAO.obtenerEjemplaresDisponibles();
        
        System.out.println("Ejemplares obtenidos: " + ejemplaresDisponibles.size()); // Depuración

        request.setAttribute("ejemplaresDisponibles", ejemplaresDisponibles);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/formularios.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idEjemplar = request.getParameter("idEjemplar");
        HttpSession session = request.getSession(false); // Obtener la sesión actual sin crear una nueva
        Usuario usuario = SessionUtils.getUsuarioFromSession(session);
        int usuarioId = usuario.getId();
        // Lógica para realizar el préstamo
        Prestamo prestamo = new Prestamo();
        LocalDate fechaActual = LocalDate.now();
        Date fechaPrestamo = Date.valueOf(fechaActual);
        // Establecer los datos del préstamo
        prestamo.setIdEjemplar(idEjemplar);
        prestamo.setIdUsuario(usuarioId);
        prestamo.setFechaPrestamo(fechaPrestamo);
        
        if (prestamo != null) {
            PrestamoDAO prestamoDAO = new PrestamoDAO();
            boolean resultado = prestamoDAO.guardarPrestamo(prestamo);
            
            if (resultado) {
                response.sendRedirect(request.getContextPath() + "/prestamo?success=true");
            } else {
                String mensaje = "No se pudo realizar el prestamo";
                request.setAttribute("mensaje", mensaje);
            }
        }
        
    }
}
