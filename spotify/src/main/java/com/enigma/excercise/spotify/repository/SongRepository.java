package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, String> {

    public Page<Song> findAllByTitleContains(String title, Pageable pageable);
}
