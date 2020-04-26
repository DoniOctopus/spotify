package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, String> {
    public Page<Artist> findAllByNameContains(String name, Pageable pageable);
}
