package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Album;
import com.enigma.excercise.spotify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping("/album/{id}")
        public Album getAlbumById(@PathVariable String id){
        return  albumService.getAlbum(id);
    }


    @PostMapping("/album")
    public void saveAlbum(@RequestBody Album album){
        albumService.saveAlbum(album);
    }

    @DeleteMapping("/album/{id}")
    public void deletAlbum(@PathVariable String id){
        albumService.deletAlbum(id);
    }

    @PostMapping
    public void saveAlbum(@RequestPart MultipartFile file, @RequestPart String requesBody) throws IOException{
        albumService.saveAlbum(file, requesBody);
    }

}
