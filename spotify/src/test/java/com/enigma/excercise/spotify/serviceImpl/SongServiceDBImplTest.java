package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Song;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.SongRepository;
import com.enigma.excercise.spotify.service.SongService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class SongServiceDBImplTest {

    @Autowired
    SongRepository songRepository;
    @Autowired
    SongService songServiceDB;

    @BeforeEach
    public void cleanUp(){
        songRepository.deleteAll();
    }

    @Test
    void saveSong_shouldAdd_1Data_inDB_whenSongSaved() {
        Song song = new Song("Berdikstraksi",2000);
        songServiceDB.saveSong(song);
        assertEquals(1,songRepository.findAll().size());
    }

    @Test
    void saveSong_shouldThrowException_whenSongIsExist() {
        Song song = new Song("Berdikstraksi",2000);
        songRepository.save(song);
        assertThrows(ResourceNotFoundExeption.class,()->{
            songServiceDB.saveSong(song);
        });
    }

    @Test
    void deleteSong_shouldDelete_1Data_inDB_whenSongDeleted() {
        Song song = new Song("Berdikstraksi",2000);
        Song song1 = new Song("Diambang Pilu",2000);
        songRepository.save(song);
        songRepository.save(song1);
        songServiceDB.deletSong(song1.getId());
        assertEquals(1,songRepository.findAll().size());
    }

    @Test
    void getAllSong_shouldBe_2InDB_whenDataInDBIs_2() {
        Song song = new Song("Berdikstraksi",2000);
        Song song2 = new Song("Diambang Pilu",2000);
        songRepository.save(song);
        songRepository.save(song2);
        assertEquals(2, songServiceDB.getAllSong().size());
    }


    @Test
    void getSongByField_shouldGetSong_whenGivenSearchValue() {
        Song song = new Song("Berdikstraksi",2000);
        Song song2 = new Song("Diambang Pilu",2000);
        songRepository.save(song);
        songRepository.save(song2);
        Song song3=new Song();
        song3.setTitle("le");
        song3.setReleaseYear(2002);
        song3.setDuration(420);
        assertEquals(0, songServiceDB.searchSong(song3, PageRequest.of(0,5)).getTotalElements());
    }


}