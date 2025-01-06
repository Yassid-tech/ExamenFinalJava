package com.poo.examenfinaljava;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class Main {
    public static void main(String[] args) {
        Client client = new Client(1, "Yassine IDRISSI");

        Ingredient viande = new Ingredient(1, "Viande", 250.0, 150);
        Ingredient pruneaux = new Ingredient(2, "Pruneaux", 1.0, 30);

        PlatPrincipal plat1 = new PlatPrincipal(1, "Tajine de viande & Pruneaux", 20.0);
        plat1.getIngredients().add(viande);
        plat1.getIngredients().add(pruneaux);

        Supplement frites = new Supplement(1, "Frites", 11.0);
        Supplement boisson = new Supplement(2, "Boisson", 12.0);

        // REPAS numero 1:
        Repas repas1 = new Repas(plat1);
        repas1.getSupplements().add(frites);
        repas1.getSupplements().add(boisson);


        Ingredient poisson = new Ingredient(3, "Poisson", 250.0, 100);
        Ingredient carotte = new Ingredient(4, "Carrote", 1.0, 20);
        Ingredient pommeDeTerre = new Ingredient(5, "Pomme de terre", 10.0, 50);
        Ingredient olive = new Ingredient(6, "Olive", 5.0, 0.2);

        PlatPrincipal plat2 = new PlatPrincipal(2, "Tajine de poulet & légumes", 25.0);
        plat2.getIngredients().add(poisson);
        plat2.getIngredients().add(carotte);
        plat2.getIngredients().add(pommeDeTerre);
        plat2.getIngredients().add(olive);

        Supplement jusOrange = new Supplement(3, "Jus d'orange", 13.0);
        Supplement saladeMarocaine = new Supplement(4, "Salade marocaine", 14.0);

        // REPAS numero 2:
        Repas repas2 = new Repas(plat2);
        repas2.getSupplements().add(jusOrange);
        repas2.getSupplements().add(saladeMarocaine);

        Commande commande = new Commande(1, client);
        commande.ajouterRepas(repas1);
        commande.ajouterRepas(repas2);


        System.out.println(commande.genererTicket());
    }
}
