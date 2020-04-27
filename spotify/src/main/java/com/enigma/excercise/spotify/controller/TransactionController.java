package com.enigma.excercise.spotify.controller;


import com.enigma.excercise.spotify.entity.Transaction;
import com.enigma.excercise.spotify.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable String id){
        return transactionService.getTransaction(id);
    }

    @PostMapping
    public Transaction saveTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }
}
