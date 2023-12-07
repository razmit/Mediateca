/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Josue
 */
public abstract class Ejemplar {

    protected String id;
    protected String titulo;
    protected String idautor;
    protected String tipo;
    protected String ubicacion;
    protected int cantidad;
    protected int prestados;
    protected String imagenURL;

    public Ejemplar() {
    }

    public Ejemplar(String id, String titulo, String idautor, String tipo, String ubicacion, int cantidad, int prestados, String imagenURL) {
        this.id = id;
        this.titulo = titulo;
        this.idautor = idautor;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
        this.prestados = prestados;
        this.imagenURL = imagenURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdautor() {
        return idautor;
    }

    public void setIdautor(String idautor) {
        this.idautor = idautor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    @Override
    public String toString() {
        return "Ejemplares{" + "id=" + id + ", titulo=" + titulo + ", idautor=" + idautor + ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", cantidad=" + cantidad + ", prestados=" + prestados + ", imagenURL=" + imagenURL + '}';
    }

}
