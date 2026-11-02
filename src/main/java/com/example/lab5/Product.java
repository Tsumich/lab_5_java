package com.example.lab5;

public class Product {

    String name;
    double price;
    String imagesPath;

    public Product(String name, double price, String imagesPath) {
        this.name = name;
        this.price = price;
        this.imagesPath = imagesPath;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return imagesPath;
    }
}
