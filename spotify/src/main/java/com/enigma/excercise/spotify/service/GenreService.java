package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Genre;

import java.util.List;

public interface GenreService {
    public void saveGenre(Genre genre);
    public Genre getGenre(String id);
    public List<Genre> getAllGenre();
    public void deletGenre(String id);
}
