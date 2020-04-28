package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.WalletHistory;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.WalletHistoryRepository;
import com.enigma.excercise.spotify.service.WalletHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class WalletHistoryDBImplTest {

    @Autowired
    WalletHistoryRepository walletHistoryRepository;

    @Autowired
    WalletHistoryService walletHistoryService;

    @BeforeEach
    public void cleanUp(){
        walletHistoryRepository.deleteAll();
    }


    @Test
    void saveWalletHistory_shouldAdd_1Data_inDB_whenWalletHistorySaved() {
        WalletHistory   walletHistory = new WalletHistory((double)1000);
        walletHistoryService.saveWalletHistory(walletHistory);
        assertEquals(1,walletHistoryRepository.findAll().size());
    }
    @Test
    void saveWalletHistory_shouldAdd_2Data_inDB_whenWalletHistorySaved() {
        WalletHistory   walletHistory = new WalletHistory((double)1000);
        WalletHistory   walletHistory1 = new WalletHistory((double)1000);
        walletHistoryService.saveWalletHistory(walletHistory);
        walletHistoryService.saveWalletHistory(walletHistory1);
        assertEquals(2,walletHistoryRepository.findAll().size());
    }

    @Test
    void getWalletHistory_ShouldThrowExecption_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundExeption.class, () -> {
            walletHistoryService.getWalletHistory("1");
        });
    }


    @Test
    void deleteWalletHistory_shouldDelete_1Data_inDB_whenWalletHistoryDeleted() {
        WalletHistory   walletHistory = new WalletHistory((double)1000);
        WalletHistory   walletHistory1 = new WalletHistory((double)2000);
        walletHistoryRepository.save(walletHistory);
        walletHistoryRepository.save(walletHistory1);
        walletHistoryService.deleteWalletHistory(walletHistory1);
        assertEquals(1,walletHistoryRepository.findAll().size());
    }
    @Test
    void searchWalletHistory() {
    }
}