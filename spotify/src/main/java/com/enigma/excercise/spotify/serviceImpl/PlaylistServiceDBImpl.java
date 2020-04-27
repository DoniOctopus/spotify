package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Playlist;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.PlaylistRepository;
import com.enigma.excercise.spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceDBImpl implements PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public void savePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    @Override
    public Playlist getPlaylist(String id) {
        Playlist playlist = new Playlist();
        if (playlistRepository.findById(id).isPresent()){
            playlist = playlistRepository.findById(id).get();
        }else{
            throw new ResourceNotFoundExeption(id,playlist);
        }
        return playlist;
    }

    @Override
    public List<Playlist> getAllPlaylist() {
        return playlistRepository.findAll();
    }

    @Override
    public void deletPlaylist(String id) {
    playlistRepository.deleteById(id);
    }

    @Override
    public Page<Playlist> searchPlaylist(Playlist playlist, Pageable pageable) {
        Page<Playlist>playlists = playlistRepository.findAllByNameContains(playlist.getName(), pageable);
        return playlists;
    }
}
