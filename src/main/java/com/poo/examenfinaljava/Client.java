package com.poo.examenfinaljava;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class Client {
    private int id;
    private String nom;
    private List<Commande> commandes;

    // Constructeurs, getters et setters
    public Client(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.commandes = new ArrayList<>();
    }

    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    // toString() pour affichage
    @Override
    public String toString() {
        return "Client: " + nom;
    }

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

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
