package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, String> {

    public Page<Playlist> findAllByNameContains(String name, Pageable pageable);

}
