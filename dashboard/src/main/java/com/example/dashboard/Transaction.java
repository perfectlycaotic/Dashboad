package com.example.dashboard;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {
    @Id
     private String id;
    private String transactionId;
    private String timestamp;
    private String customerId;
    private String customerName;
    private String productId;
    private String productName;
    private String category;
    private int quantity;
    private double pricePerUnit;
    private double totalPrice;
    private String paymentMethod;
    private String location;

    // Constructeur sans argument
    public Transaction() {}

    // Constructeur avec tous les paramètres
    public Transaction(String transactionId, String timestamp, String customerId, String customerName, String productId, String productName, String category, int quantity, double pricePerUnit, double totalPrice, String paymentMethod, String location) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.customerId = customerId;
        this.customerName = customerName;
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.location = location;
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}