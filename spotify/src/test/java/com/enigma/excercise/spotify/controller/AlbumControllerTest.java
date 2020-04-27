package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Album;
import com.enigma.excercise.spotify.service.AlbumService;
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
class AlbumControllerTest {

    @MockBean
    AlbumService albumService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAlbumById() {
    }

    @Test
    void saveDataAlbum_should_response_OK200() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Album album = new Album("Tlisik");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/album")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(album));
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveAlbum_should_respone_Album_withIdNotNull() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

        Album album = new Album("Tlisik");

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/album")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(album));

        String response = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        System.out.println("ini LOH" + response);

    }

    @Test
    void deleteAlbum_should_callAlbumService_deleteAlbum_once() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Album album = new Album("Tlisik");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/album/1");
        mockMvc.perform(requestBuilder);
        Mockito.verify(albumService, Mockito.times(1)).deletAlbum("1");
    }

    @Test
    void deleteAlbum_should_response_OK200() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        Album album = new Album("Tlisik");
        RequestBuilder requestBuilder1=MockMvcRequestBuilders.delete("/album/1");
        mockMvc.perform(requestBuilder1).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void searchByTitle() {
    }

}