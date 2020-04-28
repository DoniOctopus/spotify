package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Transaction;
import com.enigma.excercise.spotify.repository.TransactionRepository;
import com.enigma.excercise.spotify.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransactionServiceDBImplTest {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionService transactionService;

    @Test
    void getAllTransaction() {
        Transaction transaction = new Transaction((double)2000);
        Transaction transaction1 = new Transaction((double)2000);
        transactionRepository.save(transaction);
        transactionRepository.save(transaction1);
        assertEquals(3,transactionRepository.findAll(PageRequest.of(0,5)).getTotalElements());
    }
    @Test
    void deleteTransaction_shouldDelete_1Data_inDB_whenTransactionDeleted() {
        Transaction transaction = new Transaction((double)2000);
        Transaction transaction1 = new Transaction((double)2000);
        transactionRepository.save(transaction);
        transactionRepository.save(transaction1);
        transactionService.deleteTransaction(transaction1.getId());
        assertEquals(1,transactionRepository.findAll().size());
    }


    @Test
    void getTransaction() {
    }


}