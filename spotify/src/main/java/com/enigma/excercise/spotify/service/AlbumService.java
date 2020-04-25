package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Album;

import java.util.List;

public interface AlbumService {

    public void saveAlbum(Album album);
    public Album getAlbum(String id);
    public List<Album> getAllAlbum();
    public void deletAlbum(String id);
}
