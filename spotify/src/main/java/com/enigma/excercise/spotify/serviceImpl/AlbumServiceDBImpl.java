package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.FileUtil.FileUtilInterface;
import com.enigma.excercise.spotify.entity.Album;
import com.enigma.excercise.spotify.repository.AlbumRepository;
import com.enigma.excercise.spotify.service.AlbumService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class AlbumServiceDBImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    FileUtilInterface fileUtil;

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

    @Override
    public void saveAlbum(MultipartFile file, String requestBody) throws IOException {
        Album album = objectMapper.readValue(requestBody, Album.class);
        try {
            albumRepository.save(album);
            String destination = String.format("album/%s.%s",
                    album.getId().replaceAll("-", ""),
                    FilenameUtils.getExtension(file.getOriginalFilename()));
            String path = fileUtil.store(file, destination);
            album.setImage(path);
            albumRepository.save(album);
        } catch (IOException ieo) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "something happened during file upload process");
        }
    }
}
