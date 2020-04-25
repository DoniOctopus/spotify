package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.WalletHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletHistoryRepository extends JpaRepository<WalletHistory, String> {
}
