package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
       public interface AccountRepository extends JpaRepository<Account, String> {
}
