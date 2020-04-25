package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Album;
import com.enigma.excercise.spotify.repository.AlbumRepository;
import com.enigma.excercise.spotify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlbumServiceDBImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public void saveAlbum(Album album) {
        albumRepository.save(album);
    }

    @Override
    public Album getAlbum(String id) {
        Album album = albumRepository.findById(id).get();
        return album;
    }

    @Override
    public List<Album> getAllAlbum() {
        return albumRepository.findAll();
    }

    @Override
    public void deletAlbum(String id) {
        albumRepository.deleteById(id);
    }
}
