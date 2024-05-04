package com.mediateca;

import com.mediateca.utils.ConnectionDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author razmit
 */
public class Mediateca {

    private static final Logger log = LogManager.getLogger(Mediateca.class);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       log.debug("DEBUG: Este es entry point");
        System.out.println("Classpath: "+ System.getProperty("java.class.Path"));
        try {
            ConnectionDB.getConnection();
        } catch (Exception e) {
            System.out.println("Error conectando a la DB");
            e.printStackTrace();
        } finally {
        }
    }
    
}
