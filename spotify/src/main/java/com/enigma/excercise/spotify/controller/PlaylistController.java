package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Playlist;
import com.enigma.excercise.spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @PostMapping("/playlist")
    public void savePlaylist(@RequestBody Playlist playlist) {
        playlistService.savePlaylist(playlist);
    }

    @GetMapping("{id}")
    public Playlist getPlaylistById(@PathVariable String id){
        return playlistService.getPlaylist(id);
    }

    @DeleteMapping("{id}")
    public  void deletPlaylist(@PathVariable String id){
        playlistService.deletPlaylist(id);
    }

    @GetMapping("/Playlist")
    public Page<Playlist> searchByName(@RequestBody Playlist searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return playlistService.searchPlaylist(searchForm, pageable);
    }
}
