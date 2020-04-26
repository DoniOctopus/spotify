package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.FileUtil.FileUtilInterface;
import com.enigma.excercise.spotify.entity.Artist;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.ArtistRepository;
import com.enigma.excercise.spotify.service.ArtistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class ArtistServiceDBImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    FileUtilInterface fileUtil;

    @Override
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtist(String id) {
        Artist artist = new Artist();
        if (artistRepository.findById(id).isPresent()) {
            artist = artistRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundExeption(id, artist);
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

    @Override
    public void saveArtist(MultipartFile file, String requestBody) throws IOException {
        Artist artist = objectMapper.readValue(requestBody, Artist.class);
        try {
            artistRepository.save(artist);
            String destination = String.format("artists/%s.%s",
                    artist.getId().replaceAll("-", ""),
                    FilenameUtils.getExtension(file.getOriginalFilename()));
            String path = fileUtil.store(file, destination);
            artist.setPhoto(path);
            artistRepository.save(artist);
        } catch (IOException ieo) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "something happened during file upload process");
        }
    }

    @Override
    public Page<Artist> searchArtist(Artist artist, Pageable pageable) {
       Page<Artist>artists = artistRepository.findAllByNameContains(artist.getName(), pageable);
        return artists;
    }
}

