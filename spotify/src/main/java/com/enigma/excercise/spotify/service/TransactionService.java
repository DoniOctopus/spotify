package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Transaction;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface TransactionService {
    public Transaction saveTransaction(Transaction transaction);
    public Transaction getTransaction(String id);
    public Page<Transaction> searchTransaction(Pageable pageable, Transaction searchForm);
    public void deleteTransaction(String id);
}
