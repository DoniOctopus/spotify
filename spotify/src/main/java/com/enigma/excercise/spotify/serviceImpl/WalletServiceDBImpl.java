package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Wallet;
import com.enigma.excercise.spotify.entity.WalletHistory;
import com.enigma.excercise.spotify.enums.HistoryTypeEnum;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.WalletRepository;
import com.enigma.excercise.spotify.service.WalletHistoryService;
import com.enigma.excercise.spotify.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class WalletServiceDBImpl implements WalletService {
    @Autowired
    WalletRepository walletRepository;

    WalletHistoryService walletHistoryService;

    @Override
    public void saveWallet(Wallet wallet, Double topUpBalance) {
        WalletHistory walletHistory = new WalletHistory();
        wallet=walletRepository.findById(wallet.getId()).get();
        if (wallet.getOwner().getActive().equals(true)) {
            wallet.setBalance(wallet.getBalance() + topUpBalance);
            walletHistory.setType(HistoryTypeEnum.TOPUP);
            walletHistory.setTrxDate(new Timestamp(new Date().getTime()));
            walletHistory.setAmount(topUpBalance);
            walletHistory.setWallet(wallet);
            walletRepository.save(wallet);
            walletHistoryService.saveWalletHistory(walletHistory);
        }
    }

    @Override
    public void saveWithDrawl(Wallet wallet, Double withDrawl) {
        WalletHistory walletHistory = new WalletHistory();
        wallet=walletRepository.findById(wallet.getId()).get();
        if (wallet.getOwner().getActive().equals(true)){
            wallet.setBalance(wallet.getBalance() - withDrawl);
            walletHistory.setType(HistoryTypeEnum.WITHDRAWAL);
            walletHistory.setTrxDate(new Timestamp(new Date().getTime()));
            walletHistory.setAmount(withDrawl);
            walletHistory.setWallet(wallet);
            walletRepository.save(wallet);
            walletHistoryService.saveWalletHistory(walletHistory);
        }
    }

    @Override
    public Wallet getWallet(String id) {
        Wallet wallet = new Wallet();
        if (walletRepository.findById(id).isPresent()){
            wallet = walletRepository.findById(id).get();
        }else{
            throw new ResourceNotFoundExeption(id,wallet);
        }
        return wallet;
    }

    @Override
    public List<Wallet> getAllWallet() {
        return walletRepository.findAll();
    }

    @Override
    public void deleteWallet(Wallet wallet) {
        walletRepository.delete(wallet);
    }
}
