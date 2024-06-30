package com.example.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{transactionId}")
    public Optional<Transaction> getTransactionById(@PathVariable String transactionId) {
        return transactionService.getTransactionById(transactionId);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @PutMapping("/{transactionId}")
    public Transaction updateTransaction(@PathVariable String transactionId, @RequestBody Transaction transaction) {
        transaction.setId(transactionId);
        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/{transactionId}")
    public void deleteTransaction(@PathVariable String transactionId) {
        transactionService.deleteTransaction(transactionId);
    }
}
