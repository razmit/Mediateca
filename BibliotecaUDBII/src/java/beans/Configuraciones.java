
package beans;

/**
 *
 * @author Sofía
 */
public class Configuraciones {
    private String clave;
    private String valor;
        
    public Configuraciones (){
    }
    
    public Configuraciones (String clsve, String valor){
        this.clave= clave;
        this.valor= valor; 
    }
    
    public String getclave(){
        return clave;
    }
    public void setclave(String clave){
        this.clave= clave;
    }
    
    
    
    public String getvalor(){
       return valor;
    }
    public void setvalor(){
    this.valor = valor;
    }

    
    @Override
    public String toString() {
        return "Configuraciones{" + "clave=" + clave + ", valor=" + valor + '}';
    }
    
    
    
    
       
    
    
}
