package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Artist;
import com.enigma.excercise.spotify.entity.Song;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.ArtistRepository;
import com.enigma.excercise.spotify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ArtistServiceDBImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Override
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtist(String id) {
        Artist artist = new Artist();
        if (artistRepository.findById(id).isPresent()){
            artist = artistRepository.findById(id).get();
        }else{
            throw  new ResourceNotFoundExeption(id,artist);
        }
        return artist;
    }

    @Override
    public List<Artist> getAllArtist() {
        return artistRepository.findAll();
    }

    @Override
    public void deleteArtist(String id) {
        artistRepository.deleteById(id);

    }
}
