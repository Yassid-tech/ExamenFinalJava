package com.poo.examenfinaljava;

import java.sql.*;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class SupplementDAO {
    private Connection conn;

    public SupplementDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(Supplement supplement) throws SQLException {
        String query = "INSERT INTO supplements (id, nom, prix) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, supplement.getId());
            stmt.setString(2, supplement.getNom());
            stmt.setDouble(3, supplement.getPrix());
            stmt.executeUpdate();
        }
    }

    public Supplement read(int id) throws SQLException {
        String query = "SELECT * FROM supplements WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Supplement(rs.getInt("id"), rs.getString("nom"), rs.getDouble("prix"));
                }
            }
        }
        return null;
    }

    public void update(Supplement supplement) throws SQLException {
        String query = "UPDATE supplements SET nom = ?, prix = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, supplement.getNom());
            stmt.setDouble(2, supplement.getPrix());
            stmt.setInt(3, supplement.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM supplements WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
