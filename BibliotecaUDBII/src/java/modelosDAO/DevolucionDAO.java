/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelosDAO;

import beans.Devolucion;
import beans.Ejemplar;
import beans.Prestamo;
import beans.conexionDB;
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
 * @author PC
 */
public class DevolucionDAO {

    public boolean guardarDevolucion(Devolucion devolucion) {
        boolean resultado = false;

        try (Connection conn = conexionDB.getConnection()) {
            String sql = "INSERT INTO devoluciones (id_prestamo, fecha_devolucion, estado_devolucion, comentarios, id_usuario) VALUES (?, ?, ?, ?, ?)";

            String sqlPagos = "INSERT INTO pagos (id_usuario, monto, id_prestamo) VALUES (?, ?, ?)";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                LocalDate fechaActual = LocalDate.now();
                Date fechaDevolucion = Date.valueOf(fechaActual);
                stmt.setInt(1, devolucion.getIdprestamo());
                stmt.setDate(2, fechaDevolucion);
                stmt.setString(3, devolucion.getEstadodevolucion());
                stmt.setString(4, devolucion.getComentarios());
                stmt.setInt(5, devolucion.getIdUsuario());
                PreparedStatement stmt1 = conn.prepareStatement(sqlPagos);
                
                String estado = devolucion.getEstadodevolucion();
                if ("Atrasado".equals(estado)) {

                    stmt1.setInt(1, devolucion.getIdUsuario());
                    stmt1.setInt(2, 1);
                    stmt1.setInt(3, devolucion.getIdprestamo());
                    stmt1.executeUpdate();
                    stmt.executeUpdate();
                    resultado = true;
                } else {
                    stmt.executeUpdate();
                    resultado = true;
                }

            }
        } catch (SQLException e) {
            // Aquí se debe registrar la excepción con un logger
            System.err.println("Error al procesar la devolución: " + e.getMessage());

        }
        return resultado;
    }

    public List<Prestamo> obtenerPrestamosVigentesPorUsuario(int idUsuario) {
        List<Prestamo> prestamosVigentes = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = conexionDB.getConnection();
            String sql = "SELECT p.id, e.id as idEjemplar,e.titulo as ejemplarTitulo, p.fecha_prestamo "
                    + "FROM prestamos p "
                    + "JOIN ejemplares e ON p.id_ejemplar = e.id "
                    + "WHERE p.fecha_devolucion IS NULL AND p.id_usuario = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idUsuario); // Establecer el ID del usuario en la consulta
            rs = ps.executeQuery();

            while (rs.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setId(rs.getInt("id"));
                prestamo.setIdEjemplar(rs.getString("ejemplarTitulo"));
                prestamo.setFechaPrestamo(rs.getDate("fecha_prestamo"));
                // Agrega más campos según sea necesario

                prestamosVigentes.add(prestamo);
            }
        } catch (SQLException e) {
            // Manejo de la excepción
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return prestamosVigentes;
    }

}
