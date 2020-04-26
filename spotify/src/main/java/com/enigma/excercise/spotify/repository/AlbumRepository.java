package com.enigma.excercise.spotify.repository;

import com.enigma.excercise.spotify.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {

}
