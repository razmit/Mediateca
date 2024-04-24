import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public void ConnectionDB (String[] args) {

        // creates Connection object
          Connection conn1 = null;
       

        try {
            // connect way #1
            String url1 = "jdbc:mysql://localhost:3306/mediateca";
            String user = "root";
            String password = "";

            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database");
                
                //Statement stmt = conn1.createStatement();   //Creating Statement.
                //Executing Statement.
               // stmt.executeUpdate("create table `ScoreHistory`(`id` integer, `Player1` varchar(20), `Player2` varchar(20), `Score` integer)");
                //stmt.executeUpdate("insert into `ScoreHistory` values(3, 'Black', 'White', 10)");
                //stmt.executeUpdate("insert into `ScoreHistory` values(4, 'Black', 'White', 10)");
                
            }
            
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();

        }
        finally {
            if (conn1 != null) {
                try {
                    conn1.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
}
        
    }
  
}

