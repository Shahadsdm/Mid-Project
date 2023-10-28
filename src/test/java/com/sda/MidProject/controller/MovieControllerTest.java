package com.sda.MidProject.controller;


import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.Movie;
import com.sda.MidProject.entity.MovieCategory;
import com.sda.MidProject.entity.RegisterUser;
import com.sda.MidProject.repository.AdminRepository;
import com.sda.MidProject.repository.MovieRepository;
import com.sda.MidProject.service.implementations.AdminServiceImpl;
import com.sda.MidProject.service.implementations.MovieServiceImpl;
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
class MovieControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MovieRepository movieRepository;

    @Mock
    private MovieServiceImpl movieServiceImpl;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new MovieController(movieServiceImpl)).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void MoviesTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/Movies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Movie"));
    }

    @Test
    public void FindByMovieCategoryTest() throws Exception {
        List<Movie> movie = movieRepository.findByCategory(MovieCategory.HORROR);
        when(movieServiceImpl.findByMovieCategory(MovieCategory.HORROR)).thenReturn(movie);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/MovieCategory/HORROR"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        String expectedJson = "[{\"movieId\":1,\"title\":\"Movie1\",\"duration\":200.0,\"rating\":6.0,\"category\":\"HORROR\",\"admin\":{\"userId\":2,\"name\":\"Admin2\",\"email\":\"admin2@example.com\",\"role\":\"Admin\"}}," +
                "{\"movieId\":3,\"title\":\"Movie3\",\"duration\":140.0,\"rating\":8.5,\"category\":\"HORROR\",\"admin\":{\"userId\":2,\"name\":\"Admin2\",\"email\":\"admin2@example.com\",\"role\":\"Admin\"}}]";

        assertEquals(expectedJson, responseContent);
    }

    @Test
    void AddMovieTest() throws Exception {
        Admin admin = new Admin(70,"Admin70","admin70@example.com","1234");
        Movie movie = new Movie(4,"Movie4",300.0,8.9,MovieCategory.ACTION,admin);
        String requestBody = objectMapper.writeValueAsString(movie);

        MvcResult mvcResult =
                mockMvc.perform(post("/addMovie")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                        .andExpect(status().isOk())
                        .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Movie4"));
    }

    @Test
    public void testUpdateeMovieSuccess() throws Exception {
        Admin admin = new Admin(70,"Admin70","admin70@example.com","1234");
        Movie updateMovie = new Movie(4,"Movie4",100.0,8.0,MovieCategory.ACTION,admin);

        when(movieServiceImpl.updateMovieInfo(4, updateMovie,admin)).thenReturn("Movie updated successfully");

        String updatedMovieJson = objectMapper.writeValueAsString(updateMovie);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/updateMovie/4")
                        .contentType("application/json")
                        .content(updatedMovieJson))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertEquals("Movie updated Successfully", responseContent);
    }

    @Test
    public void testDeleteMovie() throws Exception {
        when(movieServiceImpl.deleteMovie(4)).thenReturn("Movie deleted successfully");

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteMovie/4"))
                .andExpect(status().isOk())
                .andExpect(content().string("Movie deleted Successfully"));
    }
}