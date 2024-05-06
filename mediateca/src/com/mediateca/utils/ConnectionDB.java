package com.mediateca.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ConnectionDB {
    
    private static final Logger log = LogManager.getLogger(ConnectionDB.class);
    
    public static Connection getConnection () throws SQLException{
          Connection conn = null;
       log.debug("DEBUG: Funciona aquí");
        
        try {
            String url = "jdbc:mysql://localhost:3306/mediateca";
            String user = "root";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);
            
            if (conn != null) {
                log.info("Connected to the DB");
                return conn;
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error, algo ha fallado en la conexión.");
            ex.printStackTrace();
            log.error("Algo ha fallado al conectar con la DB");

        }        
        return conn;
    }
  
}

