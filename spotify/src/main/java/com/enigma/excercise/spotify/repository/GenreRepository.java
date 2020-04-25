package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, String> {
}
