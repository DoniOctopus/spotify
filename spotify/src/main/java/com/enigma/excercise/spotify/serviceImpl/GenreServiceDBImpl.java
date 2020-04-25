package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Genre;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.GenreRepository;
import com.enigma.excercise.spotify.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceDBImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public void saveGenre(Genre genre) {
    genreRepository.save(genre);
    }

    @Override
    public Genre getGenre(String id) {
        Genre genre = new Genre();
        if (genreRepository.findById(id).isPresent()){
            genre = genreRepository.findById(id).get();
        }else{
            throw new ResourceNotFoundExeption(id,genre);
        }
        return genre;
    }

    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public void deletGenre(String id) {
        genreRepository.deleteById(id);

    }
}