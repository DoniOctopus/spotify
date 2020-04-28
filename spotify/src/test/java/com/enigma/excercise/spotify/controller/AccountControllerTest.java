package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Account;
import com.enigma.excercise.spotify.service.AccountService;
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
class AccountControllerTest {

    @MockBean
    AccountService accountService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveDataArtis_should_response_OK200() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        Account account = new Account(Boolean.TRUE);
        RequestBuilder requestBuilder= MockMvcRequestBuilders.post("/account")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(account));
        mockMvc.perform(requestBuilder);
    }

    @Test
    void saveArtist_should_respone_Artist_withIdNotNull() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

        Account account = new Account(Boolean.TRUE);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(account));
        String response = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();
        System.out.println("ini LOH" + response);

    }

    @Test
    void deleteArtis_should_callArtisService_deleteArtis_once() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Account account = new Account(Boolean.TRUE);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/account/1");
        mockMvc.perform(requestBuilder);
        Mockito.verify(accountService, Mockito.times(1)).deletAccount("1");
    }

    @Test
    void deleteArtis_should_response_OK200() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        Account account = new Account(Boolean.TRUE);
        RequestBuilder requestBuilder1=MockMvcRequestBuilders.delete("/account/1");
        mockMvc.perform(requestBuilder1).andExpect(MockMvcResultMatchers.status().isOk());
    }
}