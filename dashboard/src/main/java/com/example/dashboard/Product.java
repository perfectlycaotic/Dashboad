package com.example.dashboard;

public class Product {
    private String productId;
    private String productName;
    private String category;
    private double pricePerUnit;

    // Constructeur
    public Product(String productId, String productName, String category, double pricePerUnit) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.pricePerUnit = pricePerUnit;
    }

    // Getters et setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }
}