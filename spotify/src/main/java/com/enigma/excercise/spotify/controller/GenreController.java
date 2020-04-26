package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Genre;
import com.enigma.excercise.spotify.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class GenreController {

    @Autowired
    GenreService genreService;

    @PostMapping("/genre")
    public void saveGenre(@RequestBody Genre genre){
        genreService.saveGenre(genre);
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable String id){
        return genreService.getGenre(id);
    }

    @DeleteMapping("/genre/{id}")
    public void deletGenre(@PathVariable String id){
        genreService.deletGenre(id);
    }

    @GetMapping("/genre")
    public Page<Genre> searchByName(@RequestBody Genre searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return genreService.searchGenre(searchForm, pageable);
    }

}
