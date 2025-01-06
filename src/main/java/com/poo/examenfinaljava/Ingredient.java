package com.poo.examenfinaljava;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class Ingredient {
    private int id;
    private String nom;
    private double prix;
    private double quantite; // Nouveau champ pour la quantité

    public Ingredient(int id, String nom, double prix, double quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite; // Initialiser la quantité
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
