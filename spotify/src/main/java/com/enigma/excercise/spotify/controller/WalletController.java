package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Wallet;
import com.enigma.excercise.spotify.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable(name = "id")String id){
        return walletService.getWallet(id);
    }

    @GetMapping("/wallet")
    public List<Wallet> getAllWallet(){
        return walletService.getAllWallet();
    }

    @PostMapping("/topUp")
    public void saveWallet(@RequestBody Wallet wallet, @RequestParam Double topUpWallet){
        walletService.saveWallet(wallet, topUpWallet);
    }

    @PostMapping("/withDraw")
    public void saveWalletWithDraw(@PathVariable Wallet wallet, @RequestParam Double withDrawWallet){
        walletService.saveWithDrawl(wallet, withDrawWallet);
    }
}
