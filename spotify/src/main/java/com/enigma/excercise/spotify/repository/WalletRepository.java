package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {
}
