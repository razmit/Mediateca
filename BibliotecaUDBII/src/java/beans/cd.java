/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author PC
 */
public class cd extends Ejemplar {

    private int duracion;
    private int anoLanzamiento;
    private int canciones;
    private int idGenero;
    private int id_artista;

    public cd() {
    }

    public cd(int duracion, int anoLanzamiento, int canciones, int idGenero, int id_artista, String id, String titulo, String idautor, String tipo, String ubicacion, int cantidad, int prestados, int imagenURL) {
        super(id, titulo, idautor, tipo, ubicacion, cantidad, prestados, imagenURL);
        this.duracion = duracion;
        this.anoLanzamiento = anoLanzamiento;
        this.canciones = canciones;
        this.idGenero = idGenero;
        this.id_artista = id_artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public void setAnoLanzamiento(int anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

    public int getCanciones() {
        return canciones;
    }

    public void setCanciones(int canciones) {
        this.canciones = canciones;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
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
        return "cd{" + "duracion=" + duracion + ", anoLanzamiento=" + anoLanzamiento + ", canciones=" + canciones + ", idGenero=" + idGenero + ", id_artista=" + id_artista + '}';
    }
    
    
}
