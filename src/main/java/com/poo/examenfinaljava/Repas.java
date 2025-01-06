package com.poo.examenfinaljava;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class Repas {
    private PlatPrincipal plat;
    private List<Supplement> supplements;

    public Repas(PlatPrincipal plat) {
        this.plat = plat;
        this.supplements = new ArrayList<>();
    }

    // Méthode pour calculer le total du repas
    public double calculerTotal() {
        double total = plat.calculerPrix();
        for (Supplement supplement : supplements) {
            total += supplement.getPrix();
        }
        return total;
    }

    // Getters et Setters
    public PlatPrincipal getPlat() {
        return plat;
    }

    public void setPlat(PlatPrincipal plat) {
        this.plat = plat;
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        details.append("Plat: ").append(plat.getNom()).append("\n");
        details.append("Prix de base: ").append(plat.getPrixBase()).append("\n");
        details.append("Ingrédients: ");
        for (Ingredient ingredient : plat.getIngredients()) {
            details.append(ingredient.getNom()).append(" (").append(ingredient.getQuantite()).append("), ");
        }
        details.append("\nSuppléments: ");
        for (Supplement supplement : supplements) {
            details.append(supplement.getNom()).append(" (").append(supplement.getPrix()).append("), ");
        }
        details.append("\n");
        return details.toString();
    }
}
