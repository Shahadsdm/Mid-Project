package com.sda.MidProject.controller;


import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.MidProject.entity.*;
import com.sda.MidProject.repository.MovieRepository;
import com.sda.MidProject.repository.ReservationRepository;
import com.sda.MidProject.service.implementations.MovieServiceImpl;
import com.sda.MidProject.service.implementations.ReservationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ReservationControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ReservationRepository reservationRepository;

    @Mock
    private ReservationServiceImpl reservationServiceImpl;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new ReservationController(reservationServiceImpl)).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void ReservationsTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/Reservations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("1"));
    }

    @Test
    public void FindByReservationIdTest() throws Exception {
        Reservation reservation = reservationRepository.findById(1).get();
        when(reservationServiceImpl.findByReservationId(1)).thenReturn(reservation);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/Reservation/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        String expectedJson = "{\"reservationId\":1," +
                "\"movie\":{\"movieId\":1,\"title\":\"Movie1\",\"duration\":200.0,\"rating\":6.0,\"category\":\"HORROR\"," +
                "\"admin\":{\"userId\":2,\"name\":\"Admin2\",\"email\":\"admin2@example.com\",\"role\":\"Admin\"}}," +
                "\"registerUser\":{\"userId\":4,\"name\":\"User4\",\"email\":\"user4@example.com\",\"role\":\"RegisterUser\"}" +
                ",\"reservationDate\":\"2023-10-25\"}";

        assertEquals(expectedJson, responseContent);
    }

    @Test
    void AddMovieTest() throws Exception {
        Admin admin = new Admin(70, "Admin70", "admin70@example.com", "1234");
        Movie movie = new Movie(4, "Movie4", 300.0, 8.9, MovieCategory.ACTION, admin);
        RegisterUser registerUser = new RegisterUser(50, "User50", "user50@example.com", "1234");
        Reservation reservation = new Reservation();
        reservation.setMovie(movie);
        reservation.setRegisterUser(registerUser);
        String requestBody = objectMapper.writeValueAsString(reservation);

        MvcResult mvcResult =
                mockMvc.perform(post("/addReservation")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                        .andExpect(status().isOk())
                        .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("50"));
    }
}