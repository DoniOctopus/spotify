package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.WalletHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletHistoryRepository extends JpaRepository<WalletHistory, String> {
}
