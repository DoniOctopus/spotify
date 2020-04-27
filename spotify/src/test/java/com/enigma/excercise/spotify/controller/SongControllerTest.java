package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Song;
import com.enigma.excercise.spotify.service.SongService;
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
class SongControllerTest {


    @MockBean
    SongService songService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getSongById() {

    }

    @Test
    void saveDataSong_should_response_OK200() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        Song song = new Song("Berdikstraksi",2000);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/song")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(song));
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveSong_should_respone_Song_withIdNotNull() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Song song = new Song("Berdikstraksi",2000);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/song")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(song));

        String response = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        System.out.println("ini LOH" + response);
    }

    @Test
    void deleteSong_should_callSongService_deleteSong_once() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Song song = new Song("Berdikstraksi",2000);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/song/1");
        mockMvc.perform(requestBuilder);
        Mockito.verify(songService, Mockito.times(1)).deletSong("1");
    }

    @Test
    void deleteSong_should_response_OK200() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        Song song = new Song("Berdikstraksi",2000);
        RequestBuilder requestBuilder1=MockMvcRequestBuilders.delete("/song/1");
        mockMvc.perform(requestBuilder1).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void searchByTitle() {
    }
}
