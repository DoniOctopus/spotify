package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Playlist;
import com.enigma.excercise.spotify.repository.PlaylistRepository;
import com.enigma.excercise.spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlaylistServiceDBImpl implements PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public void savePlaylist(Playlist playlist) {

    }

    @Override
    public Playlist getPlaylist(String id) {
        return null;
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return null;
    }

    @Override
    public void deletPlaylist(String id) {

    }
}
