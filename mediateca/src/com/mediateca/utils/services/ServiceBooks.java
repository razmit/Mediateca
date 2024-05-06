/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mediateca.utils.services;

import com.mediateca.utils.ConnectionDB;
import com.mediateca.utils.dbmodels.ModelBooks;
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
public class ServiceBooks {

    public void createBook(ModelBooks book) throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO libro (codigo, titulo, unidades_disponibles, autor, num_paginas, editorial, isbn, ano_publicacion, tipo_material_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, book.getCodigo());
        stmt.setString(2, book.getTitulo());
        stmt.setInt(3, book.getUnidades_disponibles());
        stmt.setString(4, book.getAutor());
        stmt.setInt(5, book.getNum_paginas());
        stmt.setString(6, book.getEditorial());
        stmt.setString(7, book.getIsbn());
        stmt.setInt(8, book.getAno_publicacion());
        stmt.setInt(9, book.getTipo_material_id());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

    public List<ModelBooks> getAllBooks() throws SQLException {

        List<ModelBooks> books = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        Connection connection = ConnectionDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            ModelBooks book = new ModelBooks();
            book.setId_libro(rs.getInt("id_libro"));
            book.setCodigo(rs.getString("codigo"));
            book.setTitulo(rs.getString("titulo"));
            book.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            book.setAutor(rs.getString("autor"));
            book.setNum_paginas(rs.getInt("num_paginas"));
            book.setIsbn(rs.getString("isbn"));
            book.setAno_publicacion(rs.getInt("ano_publicacion"));
            book.setTipo_material_id(rs.getInt("tipo_material_id"));
            books.add(book);
        }
        rs.close();
        statement.close();
        connection.close();
        return books;
    }

    public ModelBooks getBookById(int id) throws SQLException {

        String sql = "SELECT * FROM libro WHERE id_libro = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        ModelBooks selectedBook = null;

        if (rs.next()) {

            selectedBook = new ModelBooks();
            selectedBook.setId_libro(rs.getInt("id_libro"));
            selectedBook.setCodigo(rs.getString("codigo"));
            selectedBook.setTitulo(rs.getString("titulo"));
            selectedBook.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            selectedBook.setAutor(rs.getString("autor"));
            selectedBook.setNum_paginas(rs.getInt("num_paginas"));
            selectedBook.setIsbn(rs.getString("isbn"));
            selectedBook.setAno_publicacion(rs.getInt("ano_publicacion"));
            selectedBook.setTipo_material_id(rs.getInt("tipo_material_id"));
        }

        rs.close();
        stmt.close();
        connection.close();
        return selectedBook;
    }

    public List<ModelBooks> searchAllBooks(String searchTerm) throws SQLException {

        List<ModelBooks> books = new ArrayList<>();
        String wildCard = "%" + searchTerm + "%";
        int numWildCard = 0;
        try {
            numWildCard = Integer.parseInt(searchTerm);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM libro WHERE (codigo LIKE '" + wildCard + "') OR (titulo LIKE '" + wildCard + "') OR (unidades_disponibles LIKE '" + numWildCard + "') OR (autor LIKE '" + wildCard + "') OR (num_paginas LIKE '" + numWildCard + "') OR (editorial LIKE '" + wildCard + "') OR (isbn LIKE '" + wildCard + "') OR (ano_publicacion LIKE '" + numWildCard + "')";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ModelBooks book = new ModelBooks();
            book.setId_libro(rs.getInt("id_libro"));
            book.setCodigo(rs.getString("codigo"));
            book.setTitulo(rs.getString("titulo"));
            book.setUnidades_disponibles(rs.getInt("unidades_disponibles"));
            book.setAutor(rs.getString("autor"));
            book.setNum_paginas(rs.getInt("num_paginas"));
            book.setIsbn(rs.getString("isbn"));
            book.setAno_publicacion(rs.getInt("ano_publicacion"));
            book.setTipo_material_id(rs.getInt("tipo_material_id"));
            books.add(book);
        }

        rs.close();
        stmt.close();
        connection.close();
        return books;
    }

    public void updateBook(ModelBooks book) throws SQLException {

        String sql = "UPDATE libro SET codigo = ?, titulo = ?, unidades_disponibles = ?, autor = ?, num_paginas = ?, editorial = ?, isbn = ?, ano_publicacion = ?, id_tipo_material = ? WHERE id_libro = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, book.getCodigo());
        stmt.setString(2, book.getTitulo());
        stmt.setInt(3, book.getUnidades_disponibles());
        stmt.setString(4, book.getAutor());
        stmt.setInt(5, book.getNum_paginas());
        stmt.setString(6, book.getEditorial());
        stmt.setString(7, book.getIsbn());
        stmt.setInt(8, book.getAno_publicacion());
        stmt.setInt(9, book.getTipo_material_id());
        stmt.setInt(10, book.getId_libro());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }

    public void deleteBook(int id) throws SQLException {

        String sql = "DELETE FROM libro WHERE id_libro = ?";
        Connection connection = ConnectionDB.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
}
