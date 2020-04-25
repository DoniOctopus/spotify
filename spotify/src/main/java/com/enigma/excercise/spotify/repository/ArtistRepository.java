package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, String> {
}
