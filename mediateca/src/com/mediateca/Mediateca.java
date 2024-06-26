package com.mediateca;

import com.mediateca.views.Login;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author razmit
 */
public class Mediateca {

    private static final Logger log = LogManager.getLogger(Mediateca.class);
    /**|
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.setProperty("log4j.configurationFile", "../../resources/log4j.properties");
        
        log.debug("Este es entry point");
        System.out.println("Classpath: "+ System.getProperty("java.class.Path"));
        try {
//            ConnectionDB.getConnection();

            Login login = new Login();
            login.setVisible(true);
                        
        } catch (Exception e) {
            System.out.println("Error conectando a la DB");
            e.printStackTrace();
        }
    }
    
}
