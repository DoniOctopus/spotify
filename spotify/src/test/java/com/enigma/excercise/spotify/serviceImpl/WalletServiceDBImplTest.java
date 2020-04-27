package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Song;
import com.enigma.excercise.spotify.entity.Wallet;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.WalletRepository;
import com.enigma.excercise.spotify.service.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class WalletServiceDBImplTest {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    WalletService walletService;

    @BeforeEach
    public void cleanUp(){
        walletRepository.deleteAll();
    }

    @Test
    void getSong_ShouldThrowExecption_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundExeption.class, () -> {
            walletService.getWallet("1");
        });
    }

    @Test
    void deleteSong_shouldDelete_1Data_inDB_whenSongDeleted() {
        Wallet wallet = new Wallet((double) 1000);
        Wallet wallet1 = new Wallet((double) 1000);
        walletRepository.save(wallet);
        walletRepository.save(wallet1);
        walletService.deleteWallet(wallet1);
        assertEquals(1,walletRepository.findAll().size());
    }

    @Test
    void getWallet() {
    }

    @Test
    void getAllWallet() {
    }

    @Test
    void deleteWallet() {
    }
}