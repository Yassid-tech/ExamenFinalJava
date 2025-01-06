package com.poo.examenfinaljava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class PlatPrincipalDAO {
    private Connection conn;

    public PlatPrincipalDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(PlatPrincipal plat) throws SQLException {
        String query = "INSERT INTO plat_principal (id, nom, prix_base) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, plat.getId());
            stmt.setString(2, plat.getNom());
            stmt.setDouble(3, plat.getPrixBase());
            stmt.executeUpdate();
        }
    }

    public PlatPrincipal read(int id) throws SQLException {
        String query = "SELECT * FROM plat_principal WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PlatPrincipal(rs.getInt("id"), rs.getString("nom"), rs.getDouble("prix_base"));
                }
            }
        }
        return null;
    }

    public void update(PlatPrincipal plat) throws SQLException {
        String query = "UPDATE plat_principal SET nom = ?, prix_base = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, plat.getNom());
            stmt.setDouble(2, plat.getPrixBase());
            stmt.setInt(3, plat.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM plat_principal WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
