package com.enigma.excercise.spotify.controller;


import com.enigma.excercise.spotify.entity.Account;
import com.enigma.excercise.spotify.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable(name = "id")String id){
        return accountService.getAccount(id);
    }
    @GetMapping
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

    @PostMapping
    public Account saveAccount(@RequestBody Account account){
        accountService.saveAccount(account);
        return account;
    }
//    @DeleteMapping
//    public void deleteAccount(@RequestBody Account account){
//        accountService.deletAccount(account);
//    }
    @PutMapping
    public void updateAccount(@RequestBody Account account){
        accountService.saveAccount(account);
    }

}
