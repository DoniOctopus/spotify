package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Song;
import com.enigma.excercise.spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("/song/{id}")
    public Song getSongById(@PathVariable String id){
        return  songService.getSong(id);
    }

    @PostMapping("/song")
    public void saveSong(@RequestBody Song song){
        songService.saveSong(song);
    }

    @DeleteMapping("/song/{id}")
    public void deletSong(@PathVariable String id){
        songService.deletSong(id);
    }

    @GetMapping("/song")
    public Page<Song> searchByTitle(@RequestBody Song searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return songService.searchSong(searchForm, pageable);
    }


}
