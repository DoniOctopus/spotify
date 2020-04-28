package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Wallet;
import com.enigma.excercise.spotify.service.WalletService;
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

@SpringBootTest
@AutoConfigureMockMvc
class WalletControllerTest {

    @MockBean
    WalletService walletService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveArtist_should_respone_Artist_withIdNotNull() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

        Wallet wallet=new Wallet((double)2000);
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/wallet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(wallet));

        String response = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        System.out.println("ini LOH" + response);

    }

}