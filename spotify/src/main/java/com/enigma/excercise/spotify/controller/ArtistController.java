package com.enigma.excercise.spotify.controller;


import com.enigma.excercise.spotify.entity.Artist;
import com.enigma.excercise.spotify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @PostMapping("/artist")
    public void saveArtist(@RequestBody Artist artist) {
        artistService.saveArtist(artist);
    }

    @GetMapping("/artist/{id}")
    public Artist getArtistById(@PathVariable String id){
        return artistService.getArtist(id);
    }

    @DeleteMapping("/artist/{id}")
    public void deletArtist(@PathVariable String id){
        artistService.deleteArtist(id);
    }

    @PostMapping("/artist/photo")
    public void saveFileArtist(@RequestPart MultipartFile file, @RequestPart String requestBody) throws IOException {
        artistService.saveFileArtist(file, requestBody);
    }

    @GetMapping("/artist")
    public Page<Artist> searchByName(@RequestBody Artist searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return artistService.searchArtist(searchForm, pageable);
    }
}
