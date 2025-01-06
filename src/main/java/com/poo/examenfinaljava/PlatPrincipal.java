package com.poo.examenfinaljava;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class PlatPrincipal {
    private int id;
    private String nom;
    private List<Ingredient> ingredients;
    private double prixBase;

    public PlatPrincipal(int id, String nom, double prixBase) {
        this.id = id;
        this.nom = nom;
        this.prixBase = prixBase;
        this.ingredients = new ArrayList<>();
    }

    // Méthode pour calculer le prix total du plat
    public double calculerPrix() {
        double total = prixBase;
        for (Ingredient ingredient : ingredients) {
            total += ingredient.getPrix();
        }
        return total;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrixBase() {
        return prixBase;
    }

    public void setPrixBase(double prixBase) {
        this.prixBase = prixBase;
    }
}
