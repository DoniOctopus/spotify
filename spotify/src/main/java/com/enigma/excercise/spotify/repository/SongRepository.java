package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, String> {
}
