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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/*
    TODO 6 Testy w Springu:
     - konfigurujemy test za pomocą adnotacji
     - użycie MockMvc i ObjectMapper: wywołanie endpointu i mapowania JSON <-> Java
 */

// Wystartuj cały kontekst Springa (specjalizowane adnotacje dla poszczególnych warst waplikacji)
@SpringBootTest
// Skonfiguruj obiekt MockMvc
@AutoConfigureMockMvc
class HobbitControllerTest {

    // Wstrzyknij zależności
    @Autowired
    private MockMvc mockMvc;
    // Możemy utworzyć z new, ale nie zmapujemy np. LocalDateTime
    @Autowired
    private ObjectMapper objectMapper;

    // Adnotacja JUnit - metoda testowa
    @Test
    // Adnotacja JUnit 5 - lepsze opisy dla testów
    @DisplayName("GET /hobbits -> HTTP 200 & 3 hobbits")
    // Lombok, zamiast throws Exception
    @SneakyThrows
    // Dodanie do projektu zależności spring security, zabezpiecza endpoint'y aplikacji
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