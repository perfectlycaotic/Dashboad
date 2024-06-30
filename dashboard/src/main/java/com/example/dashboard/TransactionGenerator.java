package com.example.dashboard;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TransactionGenerator implements CommandLineRunner {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        // Liste des produits
        List<Product> products = List.of(
                new Product("P001", "Smartphone X", "Electronics", 699.99),
                new Product("P002", "Laptop Pro", "Electronics", 1299.99),
                new Product("P003", "Wireless Headphones", "Accessories", 199.99),
                new Product("P004", "4K TV", "Electronics", 899.99),
                new Product("P005", "Smartwatch", "Accessories", 249.99)
        );

        // Liste des méthodes de paiement
        List<String> paymentMethods = List.of("Credit Card", "PayPal", "Debit Card");

        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Product product = products.get(random.nextInt(products.size()));

            Transaction transaction = new Transaction(
                String.format("T%05d", i + 1),
                LocalDateTime.now().minusMinutes(random.nextInt(60 * 24 * 30)).toString(),
                String.format("C%03d", random.nextInt(1000) + 1),
                faker.name().fullName(),
                product.getProductId(),
                product.getProductName(),
                product.getCategory(),
                random.nextInt(5) + 1,
                product.getPricePerUnit(),
                product.getPricePerUnit() * (random.nextInt(5) + 1),
                paymentMethods.get(random.nextInt(paymentMethods.size())),
                faker.address().city() + ", " + faker.address().country()
            );

            transactions.add(transaction);
        }

        transactionRepository.saveAll(transactions);
        System.out.println("10,000 transactions have been generated and saved to MongoDB");
    }

    // Classe interne pour représenter un produit
    static class Product {
        private String productId;
        private String productName;
        private String category;
        private double pricePerUnit;

        public Product(String productId, String productName, String category, double pricePerUnit) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
            this.pricePerUnit = pricePerUnit;
        }

        public String getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        public double getPricePerUnit() {
            return pricePerUnit;
        }
    }
}