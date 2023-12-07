/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Ejemplar;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelosDAO.PrestamoDAO;

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
}
