/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelosDAO;

import beans.Ejemplar;
import beans.Prestamo;
import beans.conexionDB;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Josue
 */
public class PrestamoDAO {
    
   private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PrestamoDAO.class);

    public boolean guardarPrestamo(Prestamo prestamo) {
        boolean resultado = false;

        try (Connection conn = conexionDB.getConnection()) {
            String sql = "INSERT INTO prestamos (id_usuario, id_ejemplar, fecha_prestamo) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                LocalDate fechaActual = LocalDate.now();
                Date fechaPrestamo = Date.valueOf(fechaActual);
                stmt.setInt(1, prestamo.getIdUsuario());
                stmt.setString(2, prestamo.getIdEjemplar());
                stmt.setDate(3, fechaPrestamo);

                if (stmt != null) {
                    stmt.executeUpdate();
                    resultado = true;
                }

            }
        } catch (SQLException e) {
           
            logger.error("Error al guardar el préstamo: " + e);

        }
        return resultado;
    }

    public List<Ejemplar> obtenerEjemplaresDisponibles() {
        List<Ejemplar> ejemplares = new ArrayList<>();
        String sql = "SELECT ejemplares.id, ejemplares.titulo, autores.nombre AS autor, ejemplares.tipo, ejemplares.ubicacion "
                + "FROM ejemplares "
                + "JOIN autores ON ejemplares.id_autor = autores.id "
                + "WHERE ejemplares.cantidad > ejemplares.prestados";

        try (Connection conexion = conexionDB.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar() {
                };
                ejemplar.setId(rs.getString("id"));
                ejemplar.setTitulo(rs.getString("titulo"));
                ejemplar.setIdautor(rs.getString("autor"));
                ejemplar.setTipo(rs.getString("tipo"));
                ejemplar.setUbicacion(rs.getString("ubicacion"));

                // ... establecer el resto de los campos del ejemplar
                ejemplares.add(ejemplar);
            }
        } catch (SQLException e) {
            logger.error("Error al obtener ejemplares disponibles: " + e);
            
        }

        return ejemplares;
    }

    public Prestamo obtenerPrestamoPorId(int idPrestamo) throws SQLException {
        String sql = "SELECT * FROM prestamos WHERE id = ?";

        try (Connection conexion = conexionDB.getConnection();
                PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idPrestamo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Prestamo prestamo = new Prestamo();
                    prestamo.setFechaPrestamo(rs.getDate("fecha_prestamo"));
                    return prestamo;
                }
            }
        } // El try-with-resources se encargará de cerrar los recursos automáticamente

        return null; // Retorna null si no se encontró el préstamo
    }

}
