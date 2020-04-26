package com.enigma.excercise.spotify.service;

import com.enigma.excercise.spotify.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SongService {
    public void saveSong(Song song);
    public Song getSong(String id);
    public List<Song> getAllSong();
    public void deletSong(String id);
    public Page<Song> searchSong(Song song, Pageable pageable);
}
