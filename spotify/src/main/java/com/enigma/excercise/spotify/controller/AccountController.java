package com.enigma.excercise.spotify.controller;


import com.enigma.excercise.spotify.entity.Account;
import com.enigma.excercise.spotify.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable(name = "id")String id){
        return accountService.getAccount(id);
    }

    @GetMapping("/account")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

    @PostMapping("/account/{id}")
    public Account saveAccount(@RequestBody Account account){
        accountService.saveAccount(account);
        return account;
    }
    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable String id){
        accountService.deletAccount(id);
    }

}
