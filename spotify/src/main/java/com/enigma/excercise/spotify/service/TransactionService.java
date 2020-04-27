package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public void saveTransaction(Transaction transaction);
    public Transaction getTransaction(String id);
    public List<Transaction> getAllTransaction();
    public void deleteTransaction(Transaction transaction);
}
