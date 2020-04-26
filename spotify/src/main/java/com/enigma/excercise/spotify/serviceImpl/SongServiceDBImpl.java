package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Song;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.SongRepository;
import com.enigma.excercise.spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceDBImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song getSong(String id) {
        Song song = new Song();
        if (songRepository.findById(id).isPresent()) {
            song = songRepository.findById(id).get();
        }else {
            throw new ResourceNotFoundExeption(id, song);
        }
        return song;
    }

    @Override
    public List<Song> getAllSong() {
        return songRepository.findAll();
    }

    @Override
    public void deletSong(String id) {
        songRepository.deleteById(id);
    }

    @Override
    public Page<Song> searchSong(Song song, Pageable pageable) {
        Page<Song>songs =songRepository.findAllByTitleContains(song.getTitle(), pageable);
        return songs;
    }
}
