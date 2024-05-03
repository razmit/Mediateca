/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediateca.utils.services;
import com.mediateca.utils.ConnectionDB;
import com.mediateca.utils.dbmodels.ModelCDs;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author E095713
 */
public class ServiceCDS {
    
    public void createCD(ModelCDs cd) throws SQLException
    {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO cdaudio (codigo, titulo, unidades_disponibles, artista, genero, duracion, num_canciones, tipo_material_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, cd.getCodigo());
        stmt.setString(2, cd.getTitulo());
        stmt.setInt(3, cd.getUnidades_disponibles());
        stmt.setString(4, cd.getArtista());
        stmt.setString(5, cd.getGenero());
        stmt.setInt(6, cd.getDuracion());
        stmt.setInt(7, cd.getNum_canciones());
        stmt.setInt(8, cd.getTipo_material_id());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    
    public List<ModelCDs> getAllCDs() throws SQLException {

        List<ModelCDs> cds = new ArrayList<>();
        String sql = "SELECT * FROM cdaudio";
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            ModelCDs cd = new ModelCDs();
            cd.setId_cd_audio(rs.getInt("id_cd_audio"));
            cd.setCodigo(rs.getString("codigo"));
            cd.setTitulo(rs.getString("titulo"));
            cd.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            cd.setArtista(rs.getString("artista"));
            cd.setGenero(rs.getString("genero"));
            cd.setDuracion(rs.getInt("duracion"));
            cd.setNum_canciones(rs.getInt("num_canciones"));
            cd.setTipo_material_id(rs.getInt("tipo_material_id"));
            cds.add(cd);
        }
        rs.close();
        statement.close();
        connection.close();
        return cds;
    }
    
    public ModelCDs getCDById(int id) throws SQLException {
        
        String sql = "SELECT * FROM cdaudio WHERE id_cd_audio = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        ModelCDs selectedCD = null;
        
        if (rs.next()) {
            
            selectedCD = new ModelCDs();
            selectedCD.setId_cd_audio(rs.getInt("id_cd_audio"));
            selectedCD.setCodigo(rs.getString("codigo"));
            selectedCD.setTitulo(rs.getString("titulo"));
            selectedCD.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            selectedCD.setArtista(rs.getString("artista"));
            selectedCD.setGenero(rs.getString("genero"));
            selectedCD.setDuracion(rs.getInt("duracion"));
            selectedCD.setNum_canciones(rs.getInt("num_canciones"));
            selectedCD.setTipo_material_id(rs.getInt("tipo_material_id"));
        }
        
        rs.close();
        stmt.close();
        connection.close();
        return selectedCD;
    }
    
    public void updateCD(ModelCDs cd) throws SQLException {
        
        String sql = "UPDATE cdaudio SET codigo = ?, titulo = ?, unidades_disponibles = ?, artista = ?, genero = ?, duracion = ?, num_canciones = ?, tipo_material_id = ? WHERE id_cd_audio = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, cd.getCodigo());
        stmt.setString(2, cd.getTitulo());
        stmt.setInt(3, cd.getUnidades_disponibles());
        stmt.setString(4, cd.getArtista());
        stmt.setString(5, cd.getGenero());
        stmt.setInt(6, cd.getDuracion());
        stmt.setInt(7, cd.getNum_canciones());
        stmt.setInt(8, cd.getTipo_material_id());
        stmt.setInt(9, cd.getId_cd_audio());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    
    public void deleteCD(int id) throws SQLException {
        
        String sql = "DELETE FROM cdaudio WHERE id_cd_audio = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}
