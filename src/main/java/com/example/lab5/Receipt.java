package com.example.lab5;

import java.util.HashMap;
import java.util.Map;

public class Receipt {

    private Map<Product, Integer> basket = new HashMap<>();

    public void addProduct(Product product) {
        if (basket.containsKey(product)) {
            basket.put(product, basket.get(product) + 1);
        } else {
            basket.put(product, 1);
        }
    }

    public void addProduct(Product product, int quantity) {
        basket.put(product, basket.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product) {
        if (basket.containsKey(product)) {
            int currentQuantity = basket.get(product);
            if (currentQuantity > 1) {
                basket.put(product, currentQuantity - 1);
            } else {
                basket.remove(product);
            }
        }
    }

    public void removeAll(Product product) {
        basket.remove(product);
    }

    public double getTotalPrice() {
        double total = 0.0;

        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }

        return total;
    }

    public int getQuantity(Product selectedProduct) {
        return basket.getOrDefault(selectedProduct, 0);
    }

    public Map<Product, Integer> getBasket() {
        return basket;
    }
}