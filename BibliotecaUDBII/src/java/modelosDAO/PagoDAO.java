/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelosDAO;

import beans.Pago;
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
import org.apache.log4j.Logger;

/**
 *
 * @author PC
 */
public class PagoDAO {
    
    private static final Logger logger = Logger.getLogger(PagoDAO.class);

    public boolean actualizarPago(Pago pago) {
        boolean resultado = false;

        try (Connection conn = conexionDB.getConnection()) {
            String sqlPagos = "UPDATE pagos SET fecha_pago = ? WHERE id = ?";

            try (PreparedStatement stmt = conn.prepareStatement(sqlPagos)) {

                LocalDate fechaActual = LocalDate.now();
                Date fechaPago = Date.valueOf(fechaActual);
                stmt.setDate(1, fechaPago);

                stmt.setInt(2, pago.getId()); 

                int filasAfectadas = stmt.executeUpdate();

                if (filasAfectadas > 0) {
                    resultado = true;
                }
            }
        } catch (SQLException e) {
            
            logger.error("Error al actualizar el pago: " + e);
        }

        return resultado;
    }

    public List<Pago> obtenerPagosVigentesPorUsuario(int idUsuario) {
        List<Pago> pagosVigentes = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexion = conexionDB.getConnection();
            String sql = "SELECT id, id_usuario, monto, fecha_pago, id_prestamo FROM pagos WHERE id_usuario=? AND fecha_pago IS NULL";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idUsuario); // Establecer el ID del usuario en la consulta
            rs = ps.executeQuery();

            while (rs.next()) {
                Pago pago = new Pago();
                pago.setId(rs.getInt("id"));
                pago.setIdusuario(rs.getInt("id_usuario"));
                pago.setMonto(rs.getInt("monto"));
                pago.setFechapago(rs.getDate("fecha_pago"));
                pago.setIdprestamo(rs.getInt("id_prestamo"));
                // Agrega más campos según sea necesario

                pagosVigentes.add(pago);
            }
        } catch (SQLException e) {
            
             logger.error("Error al obtener pagos vigentes: " + e);
            
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
                 logger.error("Error al cerrar recursos: " + ex);
                
            }
        }

        return pagosVigentes;
    }
}
