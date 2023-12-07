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
public class Libro extends Ejemplar {

    private String isbn;
    private int idEditorial;
    private int idedicion;
    private int edicion;
    private Date fecha_publicacion;
    private int numPag;
    private int idIdioma;

    public Libro() {
    }

    public Libro(String isbn, int idEditorial, int idedicion, int edicion, Date fecha_publicacion, int numPag, int idIdioma, String id, String titulo, String idautor, String tipo, String ubicacion, int cantidad, int prestados, String imagenURL) {
        super(id, titulo, idautor, tipo, ubicacion, cantidad, prestados, imagenURL);
        this.isbn = isbn;
        this.idEditorial = idEditorial;
        this.idedicion = idedicion;
        this.edicion = edicion;
        this.fecha_publicacion = fecha_publicacion;
        this.numPag = numPag;
        this.idIdioma = idIdioma;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    public int getIdedicion() {
        return idedicion;
    }

    public void setIdedicion(int idedicion) {
        this.idedicion = idedicion;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
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
    public String getImagenURL() {
        return imagenURL;
    }

    @Override
    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", idEditorial=" + idEditorial + ", idedicion=" + idedicion + ", edicion=" + edicion + ", fecha_publicacion=" + fecha_publicacion + ", numPag=" + numPag + ", idIdioma=" + idIdioma + '}';
    }

    
}
