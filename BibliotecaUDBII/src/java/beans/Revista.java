/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Revista extends Ejemplar {

    private String issn;
    private int numero;
    private int volumen;
    private String periodicidad;    
    private String editor;  
    private Date fecha_publicacion;

    public Revista() {
    }

    
    
    public Revista(String issn, int numero, int volumen, String periodicidad, String editor, Date fecha_publicacion, String id, String titulo, String idautor, String tipo, String ubicacion, int cantidad, int prestados, int imagenURL) {
        super(id, titulo, idautor, tipo, ubicacion, cantidad, prestados, imagenURL);
        this.issn = issn;
        this.numero = numero;
        this.volumen = volumen;
        this.periodicidad = periodicidad;
        this.editor = editor;
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getIdautor() {
        return idautor;
    }

    @Override
    public void setIdautor(String idautor) {
        this.idautor = idautor;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int getPrestados() {
        return prestados;
    }

    @Override
    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }

    @Override
    public int getImagenURL() {
        return imagenURL;
    }

    @Override
    public void setImagenURL(int imagenURL) {
        this.imagenURL = imagenURL;
    }

    @Override
    public String toString() {
        return "Revista{" + "issn=" + issn + ", numero=" + numero + ", volumen=" + volumen + ", periodicidad=" + periodicidad + ", editor=" + editor + ", fecha_publicacion=" + fecha_publicacion + '}';
    }

    
}
