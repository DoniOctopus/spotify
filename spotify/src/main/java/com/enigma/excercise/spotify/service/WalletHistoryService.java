package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.WalletHistory;

import java.util.List;

public interface WalletHistoryService {
    public void saveWalletHistory(WalletHistory walletHistory);
    public WalletHistory getWalletHistory(String id);
    public List<WalletHistory> getAllWalletHistory();
    public void deleteWalletHistory(WalletHistory walletHistory);
}
