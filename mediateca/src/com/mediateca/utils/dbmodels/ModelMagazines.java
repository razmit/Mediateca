package com.mediateca.utils.dbmodels;

import java.time.LocalDate;

/**
 *
 * @author CommieTaco
 */
public class ModelMagazines {
    
    private int id_revista;
    private String codigo;
    private String titulo;
    private int unidades_disponibles;
    private String editorial;
    private String periodicidad;
    private LocalDate fecha_publicacion;
    private int tipo_material_id;
    
    public void ModelMagazines() {
    
    }

    /**
     * @return the id_revista
     */
    public int getId_revista() {
        return id_revista;
    }

    /**
     * @param id_revista the id_revista to set
     */
    public void setId_revista(int id_revista) {
        this.id_revista = id_revista;
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
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the periodicidad
     */
    public String getPeriodicidad() {
        return periodicidad;
    }

    /**
     * @param periodicidad the periodicidad to set
     */
    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    /**
     * @return the fecha_publicacion
     */
    public LocalDate getFecha_publicacion() {
        return fecha_publicacion;
    }

    /**
     * @param fecha_publicacion the fecha_publicacion to set
     */
    public void setFecha_publicacion(LocalDate fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
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
