package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Genre;
import com.enigma.excercise.spotify.service.GenreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class GenreControllerTest {

    @MockBean
    GenreService genreService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveDataGenre_should_response_OK200() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        Genre genre = new Genre("POP");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/genre")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(genre));
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveGenre_should_respone_Genre_withIdNotNull() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Genre genre = new Genre("POP");

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/genre")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(genre));

        String response = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        System.out.println("ini LOH" + response);
    }

    @Test
    void deleteGenre_should_callGenreService_deleteGenre_once() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Genre genre = new Genre("POP");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/genre/1");
        mockMvc.perform(requestBuilder);
        Mockito.verify(genreService, Mockito.times(1)).deletGenre("1");
    }

    @Test
    void deleteGenre_should_response_OK200() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        Genre genre = new Genre("POP");
        RequestBuilder requestBuilder1=MockMvcRequestBuilders.delete("/genre/1");
        mockMvc.perform(requestBuilder1).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void searchByName() {
    }
}