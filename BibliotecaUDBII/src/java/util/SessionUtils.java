/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.Usuario;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josue
 */
public class SessionUtils {
    
     public static Usuario getUsuarioFromSession(HttpSession session) {
        if (session != null && session.getAttribute("usuario") != null) {
            return (Usuario) session.getAttribute("usuario");
        }
        return null;
    }
}
