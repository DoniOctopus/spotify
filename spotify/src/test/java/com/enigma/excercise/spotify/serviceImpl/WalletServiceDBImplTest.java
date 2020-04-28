package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Wallet;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.WalletRepository;
import com.enigma.excercise.spotify.service.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class WalletServiceDBImplTest {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    WalletService walletService;

    @BeforeEach
    public void cleanUp() {
        walletRepository.deleteAll();
    }

    @Test
    void saveWallet_shouldAdd_1Data_inDB_whenWalletSaved() {
        Wallet wallet = new Wallet((double) 1000);
        walletRepository.save(wallet);
        assertEquals(1,walletRepository.findAll().size());
    }

    @Test
    void getWallet_ShouldThrowExecption_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundExeption.class, () -> {
            walletService.getWallet("1");
        });
    }

    @Test
    void deleteWallet_shouldDelete_1Data_inDB_whenWalletDeleted() {
        Wallet wallet = new Wallet((double) 1000);
        Wallet wallet1 = new Wallet((double) 1000);
        walletRepository.save(wallet);
        walletRepository.save(wallet1);
        walletService.deleteWallet(wallet1);
        assertEquals(1, walletRepository.findAll().size());
    }

    @Test
    void getAllWallet_shouldBe_2InDB_whenDataInDBIs_2() {
        Wallet wallet = new Wallet((double) 1000);
        Wallet wallet1 = new Wallet((double) 1000);
        walletRepository.save(wallet);
        walletRepository.save(wallet1);
        assertEquals(2, walletService.getAllWallet().size());
    }
    @Test
    void searchWallet() {
    }
}