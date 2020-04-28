package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Album;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.AlbumRepository;
import com.enigma.excercise.spotify.service.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AlbumServiceDBImplTest {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;

    @BeforeEach
    public void cleanUp(){
        albumRepository.deleteAll();
    }

    @Test
    void saveAlbum_shouldAdd_1Data_inDB_whenAlbumSaved() {
        Album album = new Album("Telisik");
        albumService.saveAlbum(album);
        assertEquals(1,albumRepository.findAll().size());
    }

    @Test
    void getAlbum_ShouldThrowExecption_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundExeption.class, () -> {
            albumService.getAlbum("asal");
        });

    }

    @Test
    void deleteAlbum_shouldDelete_1Data_inDB_whenAlbumDeleted() {
        Album album = new Album("Telisik");
        Album album1 = new Album("Sahabat");
        albumRepository.save(album);
        albumRepository.save(album1);
        albumService.deletAlbum(album1.getId());
        assertEquals(1,albumRepository.findAll().size());
    }

    @Test
    void getAllSAlbum_shouldBe_2InDB_whenDataInDBIs_2() {
        Album album = new Album("Telisik");
        Album album1 = new Album("Sahabat");
        albumRepository.save(album);
        albumRepository.save(album1);
        assertEquals(2, albumService.getAllAlbum().size());
    }
    @Test
    void searchAlbum() {
    }
}