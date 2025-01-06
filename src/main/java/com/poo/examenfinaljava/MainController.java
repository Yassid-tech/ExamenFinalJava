package com.poo.examenfinaljava;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Map;

public class MainController implements Initializable {
    @FXML
    private ComboBox<PlatPrincipal> repasComboBox;

    @FXML
    private VBox ingredientsBox;

    @FXML
    private VBox supplementsBox;

    @FXML
    private Label totalLabel;

    private Map<CheckBox, Ingredient> ingredientCheckBoxes = new HashMap<>();
    private Map<CheckBox, Supplement> supplementCheckBoxes = new HashMap<>();
    private Repas repasActuel;
    private Client client;
    private Commande commande;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        client = new Client(1, "Client");
        commande = new Commande(1, client);

        repasComboBox.setOnAction(e -> {
            PlatPrincipal platSelected = repasComboBox.getSelectionModel().getSelectedItem();
            if (platSelected != null) {
                updateIngredientsList(platSelected);
                repasActuel = new Repas(platSelected);
                updateTotal();
            }
        });

        initializeData();
    }

    private void initializeData() {
        PlatPrincipal plat1 = new PlatPrincipal(1, "Tajine de viande & Pruneaux", 20.0);
        PlatPrincipal plat2 = new PlatPrincipal(2, "Tajine de poulet & légumes", 25.0);

        repasComboBox.getItems().addAll(plat1, plat2);

        List<Supplement> supplements = new ArrayList<>();
        supplements.add(new Supplement(1, "Frites", 11.0));
        supplements.add(new Supplement(2, "Boisson", 12.0));
        supplements.add(new Supplement(3, "Jus d'orange", 13.0));
        supplements.add(new Supplement(4, "Salade marocaine", 14.0));

        for (Supplement supplement : supplements) {
            CheckBox cb = new CheckBox(supplement.getNom() + " (" + supplement.getPrix() + "DH)");
            cb.setOnAction(e -> updateTotal());
            supplementCheckBoxes.put(cb, supplement);
            supplementsBox.getChildren().add(cb);
        }
    }

    private void updateIngredientsList(PlatPrincipal plat) {
        ingredientsBox.getChildren().clear();
        ingredientCheckBoxes.clear();

        List<Ingredient> ingredients = new ArrayList<>();
        if (plat.getId() == 1) {
            ingredients.add(new Ingredient(1, "Viande", 250.0, 150));
            ingredients.add(new Ingredient(2, "Pruneaux", 1.0, 30));
        } else {
            ingredients.add(new Ingredient(3, "Poisson", 250.0, 100));
            ingredients.add(new Ingredient(4, "Carrote", 1.0, 20));
            ingredients.add(new Ingredient(5, "Pomme de terre", 10.0, 50));
            ingredients.add(new Ingredient(6, "Olive", 5.0, 0.2));
        }

        for (Ingredient ingredient : ingredients) {
            CheckBox cb = new CheckBox(ingredient.getNom() + " (" + ingredient.getPrix() + "DH)");
            cb.setOnAction(e -> updateTotal());
            ingredientCheckBoxes.put(cb, ingredient);
            ingredientsBox.getChildren().add(cb);
        }
    }

    private void updateTotal() {
        if (repasActuel != null) {
            double total = repasActuel.getPlat().getPrixBase();

            for (CheckBox cb : supplementCheckBoxes.keySet()) {
                if (cb.isSelected()) {
                    total += supplementCheckBoxes.get(cb).getPrix();
                }
            }

            totalLabel.setText(String.format("%.2f DH", total));
        }
    }

    @FXML
    private void handleCommander() {
        if (repasActuel != null) {
            // Ajouter les suppléments sélectionnés
            for (CheckBox cb : supplementCheckBoxes.keySet()) {
                if (cb.isSelected()) {
                    repasActuel.getSupplements().add(supplementCheckBoxes.get(cb));
                }
            }

            commande.ajouterRepas(repasActuel);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ticket de commande");
            alert.setHeaderText("Votre commande");
            alert.setContentText(commande.genererTicket());
            alert.showAndWait();

            resetCommande();
        }
    }

    private void resetCommande() {
        repasComboBox.getSelectionModel().clearSelection();
        ingredientsBox.getChildren().clear();

        for (CheckBox cb : supplementCheckBoxes.keySet()) {
            cb.setSelected(false);
        }

        repasActuel = null;
        totalLabel.setText("0.00 DH");
    }
}