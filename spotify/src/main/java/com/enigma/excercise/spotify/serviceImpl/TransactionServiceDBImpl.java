package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Song;
import com.enigma.excercise.spotify.entity.Transaction;
import com.enigma.excercise.spotify.entity.Wallet;
import com.enigma.excercise.spotify.repository.TransactionRepository;
import com.enigma.excercise.spotify.service.SongService;
import com.enigma.excercise.spotify.service.TransactionService;
import com.enigma.excercise.spotify.service.WalletService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class TransactionServiceDBImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    WalletService walletService;

    @Autowired
    SongService songService;


    @Override
    public Transaction saveTransaction(Transaction transaction){
        //Wallet
        Wallet wallet = walletService.getWallet(transaction.getWallet().getId());
        Song item = songService.getSong(transaction.getItem().getId());
        //Set Transaction
        transaction.setAmount(item.getPrice());
        transaction.setTrxDate(new Timestamp(new Date().getTime()));
        //Update Wallet
        walletService.transactionlWallet(wallet, transaction.getAmount());
        //Save Transaction
        return transactionRepository.save(transaction);

    }

    @Override
    public Transaction getTransaction(String id) {
        Transaction transaction;
        if (transactionRepository.findById(id).isPresent()) transaction = transactionRepository.findById(id).get();
        else throw new ResourceNotFoundException(id);
        return transaction;
    }

    @Override
    public Page<Transaction> searchTransaction(Pageable pageable, Transaction searchForm) {
        return null;
    }

    @Override
    public void deleteTransaction(String id) {
        if (transactionRepository.findById(id).isPresent()) transactionRepository.deleteById(id);
        else throw new ResourceNotFoundException(id);

    }
}
