package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Wallet;

import java.util.List;

public interface WalletService {
    public void saveWallet(Wallet wallet, Double topUpBalance);
    public void saveWithDrawl(Wallet wallet, Double withDrawl);
    public Wallet getWallet(String id);
    public List<Wallet> getAllWallet();
    public void deleteWallet(Wallet wallet);
}
