package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}
