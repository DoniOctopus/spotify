package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.WalletHistory;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.WalletHistoryRepository;
import com.enigma.excercise.spotify.service.WalletHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletHistoryDBImpl implements WalletHistoryService {

    @Autowired
    WalletHistoryRepository walletHistoryRepository;


    @Override
    public void saveWalletHistory(WalletHistory walletHistory) {
        walletHistoryRepository.save(walletHistory);
    }

    @Override
    public WalletHistory getWalletHistory(String id) {
        WalletHistory walletHistory = new WalletHistory();
        if (walletHistoryRepository.findById(id).isPresent()){
            walletHistory = walletHistoryRepository.findById(id).get();
        }else{
            throw new ResourceNotFoundExeption(id,walletHistory);
        }

        return walletHistory;
    }

    @Override
    public List<WalletHistory> getAllWalletHistory() {
        return walletHistoryRepository.findAll();
    }

    @Override
    public void deleteWalletHistory(WalletHistory walletHistory) {
        walletHistoryRepository.delete(walletHistory);
    }
}
