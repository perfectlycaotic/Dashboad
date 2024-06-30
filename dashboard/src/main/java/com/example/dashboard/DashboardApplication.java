package com.example.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DashboardApplication implements CommandLineRunner {

    @Autowired
    private TransactionService transactionService;

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Appel de la méthode pour récupérer toutes les transactions
        System.out.println("Calling getAllTransactions...");
        transactionService.getAllTransactions();

        // Appel de la méthode pour récupérer une transaction spécifique
        String transactionId = "T00001";
        System.out.println("Calling getTransactionById with ID: " + transactionId);
        transactionService.getTransactionById(transactionId);

        // Attendre pour permettre la vérification des logs et des données en cache
        Thread.sleep(5000); // Attendre 5 secondes
    }
}
