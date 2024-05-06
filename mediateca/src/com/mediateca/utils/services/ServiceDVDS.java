/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediateca.utils.services;
import com.mediateca.utils.ConnectionDB;
import com.mediateca.utils.dbmodels.ModelDVDs;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author razmit
 */
public class ServiceDVDS {
    
    public void createDVD(ModelDVDs dvd) throws SQLException
    {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO dvd (codigo, titulo, unidades_disponibles, director, genero, duracion, tipo_material_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, dvd.getCodigo());
        stmt.setString(2, dvd.getTitulo());
        stmt.setInt(3, dvd.getUnidades_disponibles());
        stmt.setString(4, dvd.getDirector());
        stmt.setString(5, dvd.getGenero());
        stmt.setInt(6, dvd.getDuracion());
        stmt.setInt(7, dvd.getTipo_material_id());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    
    public List<ModelDVDs> getAllDVDs() throws SQLException {

        List<ModelDVDs> dvds = new ArrayList<>();
        String sql = "SELECT * FROM dvd";
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            ModelDVDs dvd = new ModelDVDs();
            dvd.setId_dvd(rs.getInt("id_libro"));
            dvd.setCodigo(rs.getString("codigo"));
            dvd.setTitulo(rs.getString("titulo"));
            dvd.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            dvd.setDirector(rs.getString("director"));
            dvd.setGenero(rs.getString("genero"));
            dvd.setDuracion(rs.getInt("duracion"));
            dvd.setTipo_material_id(rs.getInt("tipo_material_id"));
            dvds.add(dvd);
        }
        rs.close();
        statement.close();
        connection.close();
        return dvds;
    }
    
    public ModelDVDs getDVDById(int id) throws SQLException {
        
        String sql = "SELECT * FROM dvd WHERE id_dvd = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        ModelDVDs selectedBook = null;
        
        if (rs.next()) {
            
            selectedBook = new ModelDVDs();
            selectedBook.setId_dvd(rs.getInt("id_dvd"));
            selectedBook.setCodigo(rs.getString("codigo"));
            selectedBook.setTitulo(rs.getString("titulo"));
            selectedBook.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            selectedBook.setDirector(rs.getString("director"));
            selectedBook.setGenero(rs.getString("genero"));
            selectedBook.setDuracion(rs.getInt("duracion"));
            selectedBook.setTipo_material_id(rs.getInt("tipo_material_id"));
        }
        
        rs.close();
        stmt.close();
        connection.close();
        return selectedBook;
    }
    
    public List<ModelDVDs> searchAllDVDs(String searchTerm) throws SQLException {

        List<ModelDVDs> dvds = new ArrayList<>();
        String wildCard = "%" + searchTerm + "%";
        int numWildCard = 0;
        try {
            numWildCard = Integer.parseInt(searchTerm);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM dvd WHERE (codigo LIKE '" + wildCard + "') OR (titulo LIKE '" + wildCard + "') OR (unidades_disponibles LIKE '" + numWildCard + "') OR (director LIKE '" + wildCard + "') OR (genero LIKE '" + wildCard + "') OR (duracion LIKE '" + numWildCard + "')";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ModelDVDs dvd = new ModelDVDs();
            dvd.setId_dvd(rs.getInt("id_libro"));
            dvd.setCodigo(rs.getString("codigo"));
            dvd.setTitulo(rs.getString("titulo"));
            dvd.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            dvd.setDirector(rs.getString("director"));
            dvd.setGenero(rs.getString("genero"));
            dvd.setDuracion(rs.getInt("duracion"));
            dvd.setTipo_material_id(rs.getInt("tipo_material_id"));
            dvds.add(dvd);
        }

        rs.close();
        stmt.close();
        connection.close();
        return dvds;
    }
    
    public void updateDVD(ModelDVDs dvd) throws SQLException {
        
        String sql = "UPDATE dvd SET codigo = ?, titulo = ?, unidades_disponibles = ?, director = ?, genero = ?, duracion = ?, id_tipo_material = ? WHERE id_dvd= ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, dvd.getCodigo());
        stmt.setString(2, dvd.getTitulo());
        stmt.setInt(3, dvd.getUnidades_disponibles());
        stmt.setString(4, dvd.getDirector());
        stmt.setString(5, dvd.getGenero());
        stmt.setInt(6, dvd.getDuracion());
        stmt.setInt(7, dvd.getTipo_material_id());
        stmt.setInt(8, dvd.getId_dvd());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    
    public void deleteDVD(int id) throws SQLException {
        
        String sql = "DELETE FROM dvd WHERE id_dvd = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}
