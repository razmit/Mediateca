package com.mediateca.utils.dbmodels;

/**
 *
 * @author CommieTaco
 */
public class ModelCDs {

    private int id_cd_audio;
    private String codigo;
    private String titulo;
    private int unidades_disponibles;
    private String artista;
    private String genero;
    private int duracion;
    private int num_canciones;
    private int tipo_material_id;
    
    public void ModelCDs(){
        
    }

    /**
     * @return the id_cd_audio
     */
    public int getId_cd_audio() {
        return id_cd_audio;
    }

    /**
     * @param id_cd_audio the id_cd_audio to set
     */
    public void setId_cd_audio(int id_cd_audio) {
        this.id_cd_audio = id_cd_audio;
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
     * @return the artista
     */
    public String getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(String artista) {
        this.artista = artista;
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
     * @return the num_canciones
     */
    public int getNum_canciones() {
        return num_canciones;
    }

    /**
     * @param num_canciones the num_canciones to set
     */
    public void setNum_canciones(int num_canciones) {
        this.num_canciones = num_canciones;
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
