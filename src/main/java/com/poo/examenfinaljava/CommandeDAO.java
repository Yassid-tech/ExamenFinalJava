package com.poo.examenfinaljava;

import java.sql.*;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class CommandeDAO {
    private Connection conn;

    public CommandeDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(Commande commande) throws SQLException {
        String query = "INSERT INTO commandes (id, client_id, total) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, commande.getId());
            stmt.setInt(2, commande.getClient().getId());
            stmt.setDouble(3, commande.calculerTotal());
            stmt.executeUpdate();
        }
    }

    public Commande read(int id) throws SQLException {
        String query = "SELECT * FROM commandes WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int clientId = rs.getInt("client_id");
                    ClientDAO clientDAO = new ClientDAO(conn);
                    Client client = clientDAO.read(clientId);
                    return new Commande(rs.getInt("id"), client);
                }
            }
        }
        return null;
    }

    public void update(Commande commande) throws SQLException {
        String query = "UPDATE commandes SET client_id = ?, total = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, commande.getClient().getId());
            stmt.setDouble(2, commande.calculerTotal());
            stmt.setInt(3, commande.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM commandes WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
