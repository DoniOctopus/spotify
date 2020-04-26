package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {

    public Page<Profile> findAllByFirstNameContains(String firstName, Pageable pageable);

}
