package com.poo.examenfinaljava;

import java.sql.*;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class ClientDAO {
    private Connection conn;

    public ClientDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(Client client) throws SQLException {
        String query = "INSERT INTO clients (id, nom) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, client.getId());
            stmt.setString(2, client.getNom());
            stmt.executeUpdate();
        }
    }

    public Client read(int id) throws SQLException {
        String query = "SELECT * FROM clients WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Client(rs.getInt("id"), rs.getString("nom"));
                }
            }
        }
        return null;
    }

    public void update(Client client) throws SQLException {
        String query = "UPDATE clients SET nom = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, client.getNom());
            stmt.setInt(2, client.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM clients WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
