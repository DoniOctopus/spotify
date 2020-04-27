package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Playlist;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.PlaylistRepository;
import com.enigma.excercise.spotify.service.PlaylistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PlaylistServiceDBImplTest {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    PlaylistService playlistService;

    @BeforeEach
    public void cleanUp() {
        playlistRepository.deleteAll();
    }

    @Test
    void savePlaylist_ShouldCreate_1_In_DB_When_Playlist_Saved() {
        Playlist playlist = new Playlist("NewSong",Boolean.TRUE);
        playlistRepository.save(playlist);
        assertEquals(1, playlistRepository.findAll().size());
    }

    @Test
    void savePlaylist_ShouldCreate_2_In_DB_When_Playlist_Saved() {
        Playlist playlist = new Playlist("NewSong",Boolean.TRUE);
        Playlist playlist1 = new Playlist("OldSong",Boolean.TRUE);
        playlistRepository.save(playlist);
        assertEquals(1, playlistRepository.findAll().size());
    }

    @Test
    void getPlaylist_ShouldThrowExecption_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundExeption.class, () -> {
            playlistService.getPlaylist("1");
        });

    }

    @Test
    void deletePlaylist() {
        Playlist playlist = new Playlist("NewSong",Boolean.TRUE);
        Playlist playlist1 = new Playlist("OldSong",Boolean.TRUE);
        playlistRepository.save(playlist);
        playlistRepository.save(playlist1);
        playlistService.deletPlaylist(playlist1.getId());
        assertEquals(1, playlistRepository.findAll().size());
    }

    @Test
    void getAllDataPlaylist_SouldBe_2_In_DB_When_DataInDBIs_2() {
        Playlist playlist = new Playlist("NewSong",Boolean.TRUE);
        Playlist playlist1 = new Playlist("OldSong",Boolean.TRUE);
        playlistRepository.save(playlist);
        playlistRepository.save(playlist1);
        assertEquals(2, playlistService.getAllPlaylist().size());
    }

    @Test
    void searchPlaylist() {
    }
}