package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
}
