/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelosDAO.UsuarioDAO;

/**
 *
 * @author Josue
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario usuario = usuarioDao.obtenerUsuarioPorCorreoYContrasena(correo, contrasena);

        if (usuario != null) {
            // El usuario existe y las credenciales son correctas
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            // Redirigir según el tipo de usuario
            switch (usuario.getTipoUsuario()) {
                case "Administrador":
                    response.sendRedirect("index.jsp");
                    break;
                case "Profesor":
                    response.sendRedirect("profesor.jsp");
                    break;
                case "Alumno":
                    response.sendRedirect("alumno.jsp");
                    break;
                default:
                    response.sendRedirect("views/login.jsp"); // Redirigir a la página de inicio de sesión si el tipo de usuario no es válido
                    break;
            }
        } else {
            // El usuario no existe o las credenciales son incorrectas
            String mensaje = "Correo electrónico o contraseña incorrectos";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}
