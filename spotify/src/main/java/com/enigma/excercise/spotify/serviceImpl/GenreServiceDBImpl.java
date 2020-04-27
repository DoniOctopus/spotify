package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Genre;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.GenreRepository;
import com.enigma.excercise.spotify.service.GenreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceDBImpl implements GenreService {

    final
    GenreRepository genreRepository;

    public GenreServiceDBImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

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

    @Override
    public Page<Genre> searchGenre(Genre genre, Pageable pageable) {
        Page<Genre>genres = genreRepository.findAllByNameContains(genre.getName(), pageable);
        return genres;
    }
}
