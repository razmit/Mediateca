/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediateca.utils.services;
import com.mediateca.utils.ConnectionDB;
import com.mediateca.utils.dbmodels.ModelMagazines;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.time.Instant;
import java.time.ZoneId;

/**
 *
 * @author razmit
 */
public class ServiceMagazines {
    
    public void createMag(ModelMagazines mag) throws SQLException
    {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO revista (codigo, titulo, unidades_disponibles, editorial, periodicidad, fecha_publicacion, tipo_material_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, mag.getCodigo());
        stmt.setString(2, mag.getTitulo());
        stmt.setInt(3, mag.getUnidades_disponibles());
        stmt.setString(4, mag.getEditorial());
        stmt.setString(5, mag.getPeriodicidad());
        stmt.setString(6, mag.getFecha_publicacion());
        stmt.setInt(7, mag.getTipo_material_id());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    
    public List<ModelMagazines> getAllMags() throws SQLException {
        
        List<ModelMagazines> mags = new ArrayList<>();
        String sql = "SELECT * FROM revista";
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            ModelMagazines mag = new ModelMagazines();
            mag.setId_revista(rs.getInt("id_revista"));
            mag.setCodigo(rs.getString("codigo"));
            mag.setTitulo(rs.getString("titulo"));
            mag.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            mag.setEditorial(rs.getString("editorial"));
            mag.setPeriodicidad(rs.getString("periodicidad"));
            mag.setFecha_publicacion(rs.getString("fecha_publicacion"));
            mag.setTipo_material_id(rs.getInt("tipo_material_id"));
            mags.add(mag);
        }
        rs.close();
        statement.close();
        connection.close();
        return mags;
    }
    
    public ModelMagazines getMagById(int id) throws SQLException {
        
        Instant instant;
        String sql = "SELECT * FROM revista WHERE id_revista = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        ModelMagazines selectedMag = null;
        
        if (rs.next()) {
            
            instant = rs.getDate("fecha_publicacion").toInstant();
            selectedMag = new ModelMagazines();
            selectedMag.setId_revista(rs.getInt("id_revista"));
            selectedMag.setCodigo(rs.getString("codigo"));
            selectedMag.setTitulo(rs.getString("titulo"));
            selectedMag.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            selectedMag.setEditorial(rs.getString("editorial"));
            selectedMag.setPeriodicidad(rs.getString("periodicidad"));
            selectedMag.setFecha_publicacion(rs.getString("fecha_publicacion"));
            selectedMag.setTipo_material_id(rs.getInt("tipo_material_id"));
        }
        
        rs.close();
        stmt.close();
        connection.close();
        return selectedMag;
    }
    
    public List<ModelMagazines> searchAllMagazines(String searchTerm) throws SQLException {

        Instant instant;
        List<ModelMagazines> mags = new ArrayList<>();
        String wildCard = "%" + searchTerm + "%";
        int numWildCard = 0;
        try {
            numWildCard = Integer.parseInt(searchTerm);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM revista WHERE (codigo LIKE '" + wildCard + "') OR (titulo LIKE '" + wildCard + "') OR (unidades_disponibles LIKE '" + numWildCard + "') OR (editorial LIKE '" + wildCard + "') OR (periodicidad LIKE '" + wildCard + "') OR (fecha_publicacion LIKE '" + wildCard + "')";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ModelMagazines mag = new ModelMagazines();
            instant = rs.getDate("fecha_publicacion").toInstant();
            mag.setId_revista(rs.getInt("id_revista"));
            mag.setCodigo(rs.getString("codigo"));
            mag.setTitulo(rs.getString("titulo"));
            mag.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            mag.setEditorial(rs.getString("editorial"));
            mag.setPeriodicidad(rs.getString("periodicidad"));
            mag.setFecha_publicacion(rs.getString("fecha_publicacion"));
            mag.setTipo_material_id(rs.getInt("tipo_material_id"));
            mags.add(mag);
        }

        rs.close();
        stmt.close();
        connection.close();
        return mags;
    }
    
    public void updateMag(ModelMagazines mag) throws SQLException {
        
        String sql = "UPDATE revista SET codigo = ?, titulo = ?, unidades_disponibles = ?, editorial = ?, periodicidad = ?, fecha_publicacion = ?, id_tipo_material = ? WHERE id_revista = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, mag.getCodigo());
        stmt.setString(2, mag.getTitulo());
        stmt.setInt(3, mag.getUnidades_disponibles());
        stmt.setString(4, mag.getEditorial());
        stmt.setString(5, mag.getPeriodicidad());
        stmt.setString(6, mag.getFecha_publicacion());
        stmt.setInt(7, mag.getTipo_material_id());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    
    public void deleteMag(int id) throws SQLException {
        
        String sql = "DELETE FROM revista WHERE id_revista = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}
