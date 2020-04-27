package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.FileUtil.FileUtilInterface;
import com.enigma.excercise.spotify.entity.Album;
import com.enigma.excercise.spotify.entity.Artist;
import com.enigma.excercise.spotify.service.AlbumService;
import com.enigma.excercise.spotify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    FileUtilInterface fileUtil;

    @Autowired
    AlbumService albumService;

    @Autowired
    ArtistService artistService;

    public FileController(FileUtilInterface fileUtil, ArtistService artistService) {
        this.fileUtil = fileUtil;
        this.artistService = artistService;
    }

    @GetMapping("/artists/photos/{id}")
    public ResponseEntity<Resource> getArtistsPhotos(@PathVariable String id, HttpServletRequest request) throws FileNotFoundException {
        Artist artist = artistService.getArtist(id);
        if (artist == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found");
        Resource resource = fileUtil.read(artist.getPhoto());
        String contentType;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found");
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename =\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/albums/photos/{id}")
    public ResponseEntity<Resource> getAlbumPhotos(@PathVariable String id, HttpServletRequest request) throws FileNotFoundException {
        Album album = albumService.getAlbum(id);
        if (album == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found");
        Resource resource = fileUtil.read(album.getImage());
        String contentType;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found");
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename =\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
