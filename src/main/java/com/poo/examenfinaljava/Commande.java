package com.poo.examenfinaljava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: Lenovo
 * Created: 1/6/2025
 */
public class Commande {
    private int id;
    private Client client;
    private List<Repas> repas;

    public Commande(int id, Client client) {
        this.id = id;
        this.client = client;
        this.repas = new ArrayList<>();
    }

    // Méthode pour calculer le total de la commande
    public double calculerTotal() {
        double total = 0;
        for (Repas r : repas) {
            total += r.calculerTotal();
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Repas> getRepas() {
        return repas;
    }

    public void setRepas(List<Repas> repas) {
        this.repas = repas;
    }

    public void ajouterRepas(Repas r) {
        this.repas.add(r);
    }

    public String genererTicket() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("Bienvenue ").append(client.getNom()).append("\n");
        ticket.append("-----------------TICKET-----------------\n");
        ticket.append("Nom: ").append(client.getNom()).append("\n");
        ticket.append("Nombre de repas: ").append(repas.size()).append("\n");

        for (int i = 0; i < repas.size(); i++) {
            Repas r = repas.get(i);
            ticket.append("Repas N°").append(i + 1).append(": ")
                    .append(r.getPlat().getNom()).append("\n");
            ticket.append(r.toString()).append("\n");
        }

        ticket.append("------- Total: ").append(String.format("%.2f", calculerTotal())).append("\n");
        return ticket.toString();
    }
}
