package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Profile;
import com.enigma.excercise.spotify.service.ProfileService;
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

import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
class ProfileControllerTest {

    @MockBean
    ProfileService profileService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getProfileById() {
    }

    @Test
    void saveDataProfile_should_response_OK200() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        Profile profile = new Profile("Doni",new Date());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/profile")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(profile));
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveProfile_should_respone_Profile_withIdNotNull() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Profile profile = new Profile("Doni",new Date());

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/profile")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(profile));

        String response = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        System.out.println("ini LOH" + response);
    }

    @Test
    void deleteProfile_should_callProfileService_deleteProfile_once() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Profile profile = new Profile("Doni",new Date());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/profile/1");
        mockMvc.perform(requestBuilder);
        Mockito.verify(profileService, Mockito.times(1)).deletProfile("1");
    }

    @Test
    void deleteProfile_should_response_OK200() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        Profile profile = new Profile("Doni",new Date());
        RequestBuilder requestBuilder1=MockMvcRequestBuilders.delete("/profile/1");
        mockMvc.perform(requestBuilder1).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void searchByTitle() {
    }

}