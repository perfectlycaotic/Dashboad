package com.example.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Cacheable(value = "transactions")
    public List<Transaction> getAllTransactions() {
        System.out.println("Fetching all transactions from MongoDB");
        return transactionRepository.findAll();
    }

    @Cacheable(value = "transaction", key = "#transactionId")
    public Optional<Transaction> getTransactionById(String transactionId) {
        System.out.println("Fetching transaction with ID: " + transactionId + " from MongoDB");
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        if (transaction.isPresent()) {
            System.out.println("Caching transaction with ID: " + transactionId);
        } else {
            System.out.println("Transaction with ID: " + transactionId + " not found in MongoDB. Not caching.");
        }
        return transaction;
    }

    @CachePut(value = "transaction", key = "#transaction.id")
    public Transaction createTransaction(Transaction transaction) {
        System.out.println("Creating transaction in MongoDB");
        return transactionRepository.save(transaction);
    }

    @CachePut(value = "transaction", key = "#transaction.id")
    public Transaction updateTransaction(Transaction transaction) {
        System.out.println("Updating transaction in MongoDB");
        return transactionRepository.save(transaction);
    }

    @CacheEvict(value = "transaction", key = "#transactionId")
    public void deleteTransaction(String transactionId) {
        System.out.println("Deleting transaction with ID: " + transactionId + " from MongoDB");
        transactionRepository.deleteById(transactionId);
    }
}
