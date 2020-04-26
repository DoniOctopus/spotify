package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArtistService {
    public Artist saveArtist(Artist artist);
    public Artist getArtist(String id);
    public List<Artist> getAllArtist();
    public void deleteArtist(String id);
    public void saveArtist(MultipartFile file, String requestBody) throws IOException;
    public Page<Artist> searchArtist(Artist artist, Pageable pageable);
}
