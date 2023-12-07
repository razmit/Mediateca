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
public class Devolucion {

    private int id;
    private int idprestamo;
    private int idUsuario;
    private Date fechadevolucion;
    private String estadodevolucion;
    private String comentarios;

    public Devolucion() {
    }

    public Devolucion(int id, int idprestamo, int idUsuario, Date fechadevolucion, String estadodevolucion, String comentarios) {
        this.id = id;
        this.idprestamo = idprestamo;
        this.idUsuario = idUsuario;
        this.fechadevolucion = fechadevolucion;
        this.estadodevolucion = estadodevolucion;
        this.comentarios = comentarios;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getEstadodevolucion() {
        return estadodevolucion;
    }

    public void setEstadodevolucion(String estadodevolucion) {
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
