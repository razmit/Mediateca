/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.sql.Date;

/**
 *
 * @author kevin
 */
public class devoluciones {
    private int id;
    private int idprestamo;
    private Date fechadevolucion;
    private EstadoDevolucion estadodevolucion;
    private String comentarios;   
    
    public devoluciones () {
    }

    public devoluciones(int id, int idprestamo, Date fechadevolucion, EstadoDevolucion estadodevolucion, String comentarios) {
        this.id = id;
        this.idprestamo = idprestamo;
        this.fechadevolucion = fechadevolucion;
        this.estadodevolucion = estadodevolucion;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public Date getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public EstadoDevolucion getEstadodevolucion() {
        return estadodevolucion;
    }

    public void setEstadodevolucion(EstadoDevolucion estadodevolucion) {
        this.estadodevolucion = estadodevolucion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "devoluciones{" + "id=" + id + ", idprestamo=" + idprestamo + ", fechadevolucion=" + fechadevolucion + ", estadodevolucion=" + estadodevolucion + ", comentarios=" + comentarios + '}';
    }
    
    
    
    
    
}



