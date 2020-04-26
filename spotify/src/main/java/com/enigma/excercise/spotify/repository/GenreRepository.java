package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, String> {
    public Page<Genre> findAllByNameContains(String title, Pageable pageable);
}
