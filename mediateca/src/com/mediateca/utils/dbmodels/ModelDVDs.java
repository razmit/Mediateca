package com.mediateca.utils.dbmodels;

/**
 *
 * @author CommieTaco
 */
public class ModelDVDs {

    private int id_dvd;
    private String codigo;
    private String titulo;
    private int unidades_disponibles;
    private String director;
    private String genero;
    private int duracion;
    private int tipo_material_id;
    
    public void ModelDVDs () {
    
    }

    /**
     * @return the id_dvd
     */
    public int getId_dvd() {
        return id_dvd;
    }

    /**
     * @param id_dvd the id_dvd to set
     */
    public void setId_dvd(int id_dvd) {
        this.id_dvd = id_dvd;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the unidades_disponibles
     */
    public int getUnidades_disponibles() {
        return unidades_disponibles;
    }

    /**
     * @param unidades_disponibles the unidades_disponibles to set
     */
    public void setUnidades_disponibles(int unidades_disponibles) {
        this.unidades_disponibles = unidades_disponibles;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the tipo_material_id
     */
    public int getTipo_material_id() {
        return tipo_material_id;
    }

    /**
     * @param tipo_material_id the tipo_material_id to set
     */
    public void setTipo_material_id(int tipo_material_id) {
        this.tipo_material_id = tipo_material_id;
    }
    
}
