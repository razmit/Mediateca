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
public class Tesis extends Ejemplar {

    private String iduniversidad;
    private int anio;
    private String grado;
    private String programaAcademico;

    public Tesis() {
    }

    public Tesis(String iduniversidad, int anio, String grado, String programaAcademico, String id, String titulo, String idautor, String tipo, String ubicacion, int cantidad, int prestados, String imagenURL) {
        super(id, titulo, idautor, tipo, ubicacion, cantidad, prestados, imagenURL);
        this.iduniversidad = iduniversidad;
        this.anio = anio;
        this.grado = grado;
        this.programaAcademico = programaAcademico;
    }

    public String getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(String iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
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
        return "Tesis{" + "iduniversidad=" + iduniversidad + ", anio=" + anio + ", grado=" + grado + ", programaAcademico=" + programaAcademico + '}';
    }

    
    
}
