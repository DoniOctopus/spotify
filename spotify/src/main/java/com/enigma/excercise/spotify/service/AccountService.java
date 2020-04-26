package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Account;

import java.util.List;

public interface AccountService {
    public void saveAccount(Account account);
    public Account getAccount(String id);
    public List<Account> getAllAccount();
    public void deletAccount(String id);
}
