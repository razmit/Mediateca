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
import java.sql.Date;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;

/**
 *
 * @author razmit
 */
public class ServiceMagazines {
    
    public void createDVD(ModelMagazines mag) throws SQLException
    {
        Date sqlDate = Date.valueOf(mag.getFecha_publicacion());
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO revista (codigo, titulo, unidades_disponibles, editorial, periodicidad, fecha_publicacion, tipo_material_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, mag.getCodigo());
        stmt.setString(2, mag.getTitulo());
        stmt.setInt(3, mag.getUnidades_disponibles());
        stmt.setString(4, mag.getEditorial());
        stmt.setString(5, mag.getPeriodicidad());
        stmt.setDate(6, sqlDate);
        stmt.setInt(7, mag.getTipo_material_id());
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    
    public List<ModelMagazines> getAllDVDs() throws SQLException {
        
        Instant instant;
        List<ModelMagazines> mags = new ArrayList<>();
        String sql = "SELECT * FROM revista";
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            ModelMagazines mag = new ModelMagazines();
            instant = rs.getDate("fecha_publicacion").toInstant();
            mag.setId_revista(rs.getInt("id_revista"));
            mag.setCodigo(rs.getString("codigo"));
            mag.setTitulo(rs.getString("titulo"));
            mag.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            mag.setEditorial(rs.getString("editorial"));
            mag.setPeriodicidad(rs.getString("periodicidad"));
            mag.setFecha_publicacion(instant.atZone(ZoneId.systemDefault()).toLocalDate());
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
            selectedMag.setFecha_publicacion(instant.atZone(ZoneId.systemDefault()).toLocalDate());
            selectedMag.setTipo_material_id(rs.getInt("tipo_material_id"));
        }
        
        rs.close();
        stmt.close();
        connection.close();
        return selectedMag;
    }
    
    public void updateMag(ModelMagazines mag) throws SQLException {
        
        Date sqlDate = Date.valueOf(mag.getFecha_publicacion());
        String sql = "UPDATE revista SET codigo = ?, titulo = ?, unidades_disponibles = ?, editorial = ?, periodicidad = ?, fecha_publicacion = ?, id_tipo_material = ? WHERE id_revista = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, mag.getCodigo());
        stmt.setString(2, mag.getTitulo());
        stmt.setInt(3, mag.getUnidades_disponibles());
        stmt.setString(4, mag.getEditorial());
        stmt.setString(5, mag.getPeriodicidad());
        stmt.setDate(6, sqlDate);
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
