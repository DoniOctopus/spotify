package com.enigma.excercise.spotify.service;


import com.enigma.excercise.spotify.entity.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlaylistService {

    public void savePlaylist(Playlist playlist);
    public Playlist getPlaylist(String id);
    public List<Playlist> getAllPlaylist();
    public void deletPlaylist(String id);
    public Page<Playlist> searchPlaylist(Playlist playlist, Pageable pageable);

}
