package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Account;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.AccountRepository;
import com.enigma.excercise.spotify.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceDBImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void saveAccount(Account account) {
    accountRepository.save(account);
    }

    @Override
    public Account getAccount(String id) {
        Account account = new Account();
        if (accountRepository.findById(id).isPresent()){
            account = accountRepository.findById(id).get();
        }else {
            throw new ResourceNotFoundExeption(id, account);
        }
        return account;
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void deletAccount(String id) {
    accountRepository.deleteById(id);
    }

}
