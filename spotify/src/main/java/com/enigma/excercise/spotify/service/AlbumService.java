package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AlbumService {

    public void saveAlbum(Album album);
    public Album getAlbum(String id);
    public List<Album> getAllAlbum();
    public void deletAlbum(String id);
    public void saveAlbum(MultipartFile file, String requestBody) throws IOException;
}
