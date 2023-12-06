
package beans;

import java.sql.Date;

/**
 *
 * @author Sofía
 */
public class Prestamos {
    private int id;
    private int idUsuario;
    private String idEjemplar;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    
    public Prestamos (){
        
    }
    
    public Prestamos (int id, int idUsuario, String idEjemplar, Date fechaPrestamo, Date fechaDevolucion){
     this.id= id;
     this.idUsuario = idUsuario;
     this.idEjemplar= idEjemplar;
     this.fechaPrestamo= fechaPrestamo;
     this.fechaPrestamo= fechaDevolucion;
             
    }
    
    
    public int getid(){
    return id; 
    }
    public void setid(int id){
        this.id=id;
            }
    
    
    
    
    public int getidUsuario(){
    return idUsuario; 
    }
    
   public void setidUsuario (int idUsuario){
   this.idUsuario= idUsuario;
      }
   
   
   
   
   public String getidEjemplar(){
   return idEjemplar; 
    }
    public void setidEjemplar(String idEjemplar){
    this.idEjemplar= idEjemplar;
    }
    
    
    
    
    public Date getfechaPrestamo(){
        return fechaPrestamo;
    } 
    
    public void setfechaPrestamo(){
        this.fechaPrestamo= fechaPrestamo;
    }
    
    
    
    
    public Date getfechaDevolucion(){
        return fechaDevolucion;
    }
    public void setfechaDevolucion(){
        this.fechaDevolucion= fechaDevolucion;
    }

    
    @Override
    public String toString() {
        return "Prestamos{" + "id=" + id + ", idUsuario=" + idUsuario + ", idEjemplar=" + idEjemplar + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + '}';
    }
    
}
