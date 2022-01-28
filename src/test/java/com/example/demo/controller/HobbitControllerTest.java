package com.example.demo.controller;

import com.example.demo.model.Hobbit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
/*
    TODO 3 uruchomienie testu z profilem
     możemy uruchamiać aplikację z kilkoma profilami
 */
@ActiveProfiles(profiles = "impl")
class HobbitControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("GET /hobbits -> HTTP 200 & 3 hobbits")
    @SneakyThrows
    @WithMockUser
    void findAll() {

        var endpoint = "/hobbits";
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get(endpoint))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        var hobbitsAsJSON = mvcResult.getResponse().getContentAsString();

        List<Hobbit> hobbitsFromDB = objectMapper.readValue(hobbitsAsJSON, new TypeReference<>() {});

        assertAll(
                () -> assertEquals(3, hobbitsFromDB.size()),
                () -> assertEquals("Frodo", hobbitsFromDB.get(0).getName()),
                () -> assertEquals("Bilbo", hobbitsFromDB.get(1).getName()),
                () -> assertEquals("Penelope", hobbitsFromDB.get(2).getName())
        );

    }
}