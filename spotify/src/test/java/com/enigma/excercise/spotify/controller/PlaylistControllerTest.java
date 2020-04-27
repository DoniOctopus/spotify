package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Playlist;
import com.enigma.excercise.spotify.service.PlaylistService;
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
class PlaylistControllerTest {

    @MockBean
    PlaylistService playlistService;

    @Autowired
    MockMvc mockMvc;


    @Test
    void getPlaylistById() {
    }

    @Test
    void saveDataPlaylist_should_response_OK200() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Playlist playlist = new Playlist("SongNew",Boolean.TRUE);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/playlist")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(playlist));
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void savePlaylist_should_respone_Playlist_withIdNotNull() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Playlist playlist = new Playlist("SongNew",Boolean.TRUE);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/playlist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(playlist));

        String response = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        System.out.println("ini LOH" + response);
    }

    @Test
    void deletePlaylist_should_callPlaylistService_deletePlaylist_once() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Playlist playlist = new Playlist("SongNew",Boolean.TRUE);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/playlist/1");
        mockMvc.perform(requestBuilder);
        Mockito.verify(playlistService, Mockito.times(1)).deletPlaylist("1");
    }

    @Test
    void deletePlaylist_should_response_OK200() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        Playlist playlist = new Playlist("SongNew",Boolean.TRUE);
        RequestBuilder requestBuilder1=MockMvcRequestBuilders.delete("/playlist/1");
        mockMvc.perform(requestBuilder1).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void searchByName() {
    }
}