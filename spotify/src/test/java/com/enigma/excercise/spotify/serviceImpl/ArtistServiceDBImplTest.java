package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Artist;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.ArtistRepository;
import com.enigma.excercise.spotify.service.ArtistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArtistServiceDBImplTest {

    @Autowired
    ArtistRepository artisRepository;

    @Autowired
    ArtistService artisServiceDB;

    @BeforeEach
    public void cleanUp() {
        artisRepository.deleteAll();
    }

    @Test
    void saveArtis_ShouldCreate_1_In_DB_When_Artis_Saved() {
        Artist artis = new Artist("Doni", new Date());
        artisRepository.save(artis);
        assertEquals(1, artisRepository.findAll().size());
    }

    @Test
    void saveArtis_ShouldCreate_2_In_DB_When_Artis_Saved() {
        Artist artis = new Artist("Doni", new Date());
        Artist artis2 = new Artist("Maul", new Date());
        artisRepository.save(artis);
        assertEquals(1, artisRepository.findAll().size());
    }

    @Test
    void saveArtis_ShouldCreate_Save_CorrectName_Artis_InDB_When_Artis_Saved() {
        Artist expectedArtis = new Artist("Doni", new Date());
        expectedArtis = artisServiceDB.saveArtist(expectedArtis);
        assertEquals(expectedArtis, artisRepository.findById(expectedArtis.getId()));
    }

    @Test
    void getArtist_ShouldThrowExecption_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundExeption.class, () -> {
            artisServiceDB.getArtist("asal");
        });

    }

    @Test
    void deleteArtist() {
        Artist artis = new Artist("Maul", new Date());
        Artist artis2 = new Artist("Doni", new Date());
        artisRepository.save(artis);
        artisRepository.save(artis2);
        artisServiceDB.deleteArtist(artis2.getId());
        assertEquals(1, artisRepository.findAll().size());
    }

    @Test
    void getAllDataAartis_SouldBe_2_In_DB_When_DataInDBIs_2() {
        Artist artis = new Artist("Maul", new Date());
        Artist artis2 = new Artist("Doni", new Date());
        artisRepository.save(artis);
        artisRepository.save(artis2);
        assertEquals(2, artisServiceDB.getAllArtist().size());
    }

    @Test
    void searchArtist() {
    }
}