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

import java.util.List;

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

    private final Receipt receipt = new Receipt();
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

            if (index == 0) {
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
        receipt.addProduct(selectedProduct);
        refreshCounter();
        refreshCartView();
    }

    public void removeProduct(ActionEvent e) {
        if (selectedProduct == null) return;
        receipt.removeProduct(selectedProduct);
        refreshCounter();
        refreshCartView();
    }

    private void refreshCounter() {
        int count = receipt.getQuantity(selectedProduct);
        currentProductCount.setText(String.valueOf(count));
    }

    private void refreshCartView() {
        cartView.clear();
        receipt.getBasket().forEach((product, quantity) ->
                cartView.add(product.getName() + " x" + quantity + " = " + (product.getPrice() * quantity) + " руб.")
        );
    }

    public void checkout(ActionEvent actionEvent) {
        double total = receipt.getTotalPrice();
        cartView.add("ИТОГО: " + total + " руб.");
    }
}