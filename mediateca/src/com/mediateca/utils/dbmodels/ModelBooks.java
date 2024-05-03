package com.mediateca.utils.dbmodels;

/**
 *
 * @author CommieTaco
 */
public class ModelBooks {
    
    private int id_libro;
    private String codigo;
    private String titulo;
    private int unidades_disponibles;
    private String autor;
    private int num_paginas;
    private String editorial;
    private String isbn;
    private int ano_publicacion;
    private int tipo_material_id; 
    
    public void  ModelBooks(){
        
    }

    /**
     * @return the id_libro
     */
    public int getId_libro() {
        return id_libro;
    }

    /**
     * @param id_libro the id_libro to set
     */
    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
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
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the num_paginas
     */
    public int getNum_paginas() {
        return num_paginas;
    }

    /**
     * @param num_paginas the num_paginas to set
     */
    public void setNum_paginas(int num_paginas) {
        this.num_paginas = num_paginas;
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
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the ano_publicacion
     */
    public int getAno_publicacion() {
        return ano_publicacion;
    }

    /**
     * @param ano_publicacion the ano_publicacion to set
     */
    public void setAno_publicacion(int ano_publicacion) {
        this.ano_publicacion = ano_publicacion;
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
