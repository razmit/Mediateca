/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelosDAO;

import beans.Usuario;
import beans.conexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Josue
 */
public class UsuarioDAO {
    
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UsuarioDAO.class);

    private static final String SQL_SELECT_BY_EMAIL_AND_PASSWORD = "SELECT id, nombre, correo, tipo_usuario, mora FROM usuarios WHERE correo = ? AND contrasena = ?";

    public Usuario obtenerUsuarioPorCorreoYContrasena(String correo, String contrasena) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            conn = conexionDB.getConnection();
            if (conn == null) {
                throw new SQLException("No se pudo establecer conexión con la base de datos");
            }

            stmt = conn.prepareStatement(SQL_SELECT_BY_EMAIL_AND_PASSWORD);
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                usuario.setMora(rs.getBigDecimal("mora"));
            }
        } catch (SQLException ex) {
             logger.error("Error al obtener usuario por correo y contraseña: " + ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                 logger.error("Error al cerrar recursos: " +e);
              
            }
        }
        return usuario;
    }
}
