package com.enigma.excercise.spotify.controller;

import com.enigma.excercise.spotify.entity.Transaction;
import com.enigma.excercise.spotify.service.TransactionService;
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
class TransactionControllerTest {

    @MockBean
    TransactionService transactionService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveDataTransaction_should_response_OK200() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        Transaction transaction = new Transaction((double)1000);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/transaction")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(transaction));
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveTransaction_should_respone_Transaction_withIdNotNull() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Transaction transaction = new Transaction((double)1000);

        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transaction));

        String response = mockMvc.perform(requestBuilder).andReturn().getResponse().getContentAsString();

        System.out.println("ini LOH" + response);
    }

    @Test
    void deleteTransaction_should_callTransactionService_deleteTransaction_once() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Transaction transaction = new Transaction((double)1000);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/transaction/1");
        mockMvc.perform(requestBuilder);
        Mockito.verify(transactionService, Mockito.times(1)).deleteTransaction("1");
    }

    @Test
    void deleteTransaction_should_response_OK200() throws Exception{
        ObjectMapper objectMapper=new ObjectMapper();
        Transaction transaction = new Transaction((double)1000);
        RequestBuilder requestBuilder1=MockMvcRequestBuilders.delete("/transaction/1");
        mockMvc.perform(requestBuilder1).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void getTransactionById() {
    }

}