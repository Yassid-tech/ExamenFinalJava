package com.poo.examenfinaljava;

import java.sql.*;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class IngredientDAO {
    private Connection conn;

    public IngredientDAO(Connection conn) {
        this.conn = conn;
    }

    // Création d'un ingrédient dans la base de données
    public void create(Ingredient ingredient) throws SQLException {
        String query = "INSERT INTO ingredients (id, nom, prix, quantite) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, ingredient.getId());
            stmt.setString(2, ingredient.getNom());
            stmt.setDouble(3, ingredient.getPrix());
            stmt.setDouble(4, ingredient.getQuantite()); // Ajouter la quantité
            stmt.executeUpdate();
        }
    }

    // Lecture d'un ingrédient depuis la base de données
    public Ingredient read(int id) throws SQLException {
        String query = "SELECT * FROM ingredients WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ingredient(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getDouble("prix"),
                            rs.getDouble("quantite") // Récupérer la quantité
                    );
                }
            }
        }
        return null;
    }

    // Mise à jour d'un ingrédient
    public void update(Ingredient ingredient) throws SQLException {
        String query = "UPDATE ingredients SET nom = ?, prix = ?, quantite = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, ingredient.getNom());
            stmt.setDouble(2, ingredient.getPrix());
            stmt.setDouble(3, ingredient.getQuantite()); // Mettre à jour la quantité
            stmt.setInt(4, ingredient.getId());
            stmt.executeUpdate();
        }
    }

    // Suppression d'un ingrédient
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM ingredients WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
