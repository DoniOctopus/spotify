package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Artist;
import com.enigma.excercise.spotify.service.ArtistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
class ArtistControllerTest {

    @MockBean
    ArtistService artistService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveDataArtis_should_response_OK200() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Artist artist = new Artist("Doni", new Date());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/artist")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(artist));
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void getArtistById() {
    }

    @Test
    void deletArtist() {
    }

    @Test
    void testSaveArtist() {
    }

    @Test
    void searchByName() {
    }
}