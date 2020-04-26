package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenreService {
    public void saveGenre(Genre genre);
    public Genre getGenre(String id);
    public List<Genre> getAllGenre();
    public void deletGenre(String id);
    public Page<Genre> searchGenre(Genre genre, Pageable pageable);

}
