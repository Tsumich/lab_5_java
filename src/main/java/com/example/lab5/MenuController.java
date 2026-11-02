package com.example.lab5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuController {

    public ImageView currentProduct;
    public Label currentProductName;
    public Label currentProductPrice;
    public Label currentProductCount;
    public Button add;
    public Button remove;

    @FXML
    private GridPane dishesGrid;

    @FXML
    private ListView<String> cartList;


    private final Product cola = new Product("Кириешки", 22.0, "kiri");
    private final Product coffee = new Product("Эспрессо", 40.0, "coffee");
    private final Product onigiri = new Product("Онигири с васаби", 80.0, "onigiri");
    private final Product chips = new Product("Чипсы", 90.0, "chips");

    private final Map<Product, Integer> cart = new HashMap<>();
    private final ObservableList<String> cartView = FXCollections.observableArrayList();

    private Product selectedProduct;

    @FXML
    protected void changeToAnime() {
    }

    @FXML
    public void initialize() {
        cartList.setItems(cartView);

        List<Product> menu = List.of(cola, coffee, onigiri, chips);

        int column = 0;
        int row = 0;
        int index = 0;
        for (Product product : menu) {
            ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/" + product.getImage() + ".jpg")));
            imageView.setFitWidth(80);
            imageView.setFitHeight(80);
            imageView.setPreserveRatio(true);

            if(index == 0){
                selectedProduct = product;
                currentProduct.setImage(imageView.getImage());
                currentProductName.setText(product.getName());
                currentProductPrice.setText("Цена: " + product.getPrice() + " руб.");
            }
            index++;

            imageView.setOnMouseClicked(event -> {
                selectedProduct = product;
                currentProduct.setImage(imageView.getImage());
                currentProductName.setText(product.getName());
                currentProductPrice.setText("Цена: " + product.getPrice() + " руб.");
                refreshCounter();
            });

            dishesGrid.add(imageView, column, row);

            column++;
            if (column == 3) {
                column = 0;
                row++;
            }
        }

    }

    public void addProduct(ActionEvent e) {
        if (selectedProduct == null) return;
        cart.merge(selectedProduct, 1, Integer::sum);
        refreshCounter();
        refreshCartView();
    }

    public void removeProduct(ActionEvent e) {
        if (selectedProduct == null) return;
        cart.computeIfPresent(selectedProduct, (p, q) -> q > 1 ? q - 1 : null);
        refreshCounter();
        refreshCartView();
    }

    public void checkout(ActionEvent actionEvent) {
        double total = cart.entrySet().stream()
                .mapToDouble(en -> en.getKey().getPrice() * en.getValue())
                .sum();
        cartView.add("ИТОГО: " + total + " руб.");
    }

    private void refreshCounter() {
        currentProductCount.setText(String.valueOf(cart.getOrDefault(selectedProduct, 0)));
    }

    private void refreshCartView() {
        cartView.clear();
        cart.forEach((p, q) -> cartView.add(p.getName() + " x" + q + " = " + (p.getPrice() * q) + " руб."));
    }
}