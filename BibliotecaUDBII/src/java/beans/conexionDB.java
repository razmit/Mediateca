/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import modelosDAO.UsuarioDAO;

/**
 *
 * @author Josue
 */
public class conexionDB {
    
 private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(conexionDB.class);

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
           logger.error("Error al conectar a la base de datos: {}",e);
        }
        return connection;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                logger.info("Conexión cerrada");
            } catch (SQLException e) {
                logger.error("Error al cerrar la conexión: {}", e);
            }
        }
    }

}
