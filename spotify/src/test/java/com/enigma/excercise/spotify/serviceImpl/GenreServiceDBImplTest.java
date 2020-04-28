package com.enigma.excercise.spotify.serviceImpl;

import com.enigma.excercise.spotify.entity.Genre;
import com.enigma.excercise.spotify.exception.ResourceNotFoundExeption;
import com.enigma.excercise.spotify.repository.GenreRepository;
import com.enigma.excercise.spotify.service.GenreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class GenreServiceDBImplTest {

    @Autowired
    GenreRepository genreRepository;
    
    @Autowired
    GenreService genreService;

    @BeforeEach
    public void cleanUp(){
        genreRepository.deleteAll();
    }

    @Test
    void saveGenre_shouldAdd_1Data_inDB_whenGenreSaved() {
        Genre genre = new Genre("POP");
        genreService.saveGenre(genre);
        assertEquals(1,genreRepository.findAll().size());
    }

    @Test
    void getGenre_ShouldThrowExecption_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundExeption.class, () -> {
            genreService.getGenre("1");
        });
    }

    @Test
    void deleteGenre_shouldDelete_1Data_inDB_whenGenreDeleted() {
        Genre genre = new Genre("POP");
        Genre genre1 = new Genre("CLASIC");
        genreRepository.save(genre);
        genreRepository.save(genre1);
        genreService.deletGenre(genre1.getId());
        assertEquals(1,genreRepository.findAll().size());
    }

    @Test
    void getAllGenre_shouldBe_2InDB_whenDataInDBIs_2() {
        Genre genre = new Genre("POP");
        Genre genre1 = new Genre("CLASIC");
        genreRepository.save(genre);
        genreRepository.save(genre1);
        assertEquals(2,genreService.getAllGenre().size());
    }

    @Test
    void getvByField_shouldGetGenre_whenGivenSearchValue() {
        Genre genre = new Genre("POP");
        Genre genre1 = new Genre("CLASIC");
        genreRepository.save(genre);
        genreRepository.save(genre1);
        Genre genre3=new Genre();
        genre3.setName("le");
        assertEquals(0, genreService.searchGenre(genre3, PageRequest.of(0,5)).getTotalElements());
    }

    @Test
    void searchGenre() {
    }
}