package com.mediateca.utils;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    
    public void ConnectionDB () {
          Connection conn = null;
       

        try {
            String url = "jdbc:mysql://localhost:3306/mediateca";
            String user = "root";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
                
                Statement stmt = conn.createStatement();   //Creating Statement.
                //Executing Statement.
                stmt.executeUpdate("create table `ScoreHistory`(`id` integer, `Player1` varchar(20), `Player2` varchar(20), `Score` integer)");
                stmt.executeUpdate("insert into `ScoreHistory` values(3, 'Black', 'White', 10)");
                stmt.executeUpdate("insert into `ScoreHistory` values(4, 'Black', 'White', 10)");
                
            }
            
        } catch (SQLException ex) {
            System.out.println("Error, algo ha fallado en la conexión.");
            ex.printStackTrace();

        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
}
        
    }
  
}

