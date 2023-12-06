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
public class pagos {
    private int id;
    private int idusuario;
    private float monto;
    private Date fechapago;
    private int idprestamo;
    private String idejemplar;
    
    public pagos() {
    }

    public pagos(int id, int idusuario, float monto, Date fechapago, int idprestamo, String idejemplar) {
        this.id = id;
        this.idusuario = idusuario;
        this.monto = monto;
        this.fechapago = fechapago;
        this.idprestamo = idprestamo;
        this.idejemplar = idejemplar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public String getIdejemplar() {
        return idejemplar;
    }

    public void setIdejemplar(String idejemplar) {
        this.idejemplar = idejemplar;
    }

    @Override
    public String toString() {
        return "pagos{" + "id=" + id + ", idusuario=" + idusuario + ", monto=" + monto + ", fechapago=" + fechapago + ", idprestamo=" + idprestamo + ", idejemplar=" + idejemplar + '}';
    }
    
       
    
    
    
    
}
