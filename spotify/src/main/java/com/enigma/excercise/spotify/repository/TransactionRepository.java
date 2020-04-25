package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
