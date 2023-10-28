package com.sda.MidProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.RegisterUser;
import com.sda.MidProject.repository.AdminRepository;
import com.sda.MidProject.repository.RegisterUserRepository;
import com.sda.MidProject.service.implementations.AdminServiceImpl;
import com.sda.MidProject.service.implementations.RegisterUserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.print.attribute.standard.MediaName;
import java.awt.*;
import java.lang.runtime.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

class RegisterUserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private RegisterUserRepository registerUserRepository;

    @Mock
    private RegisterUserServiceImpl registerUserServiceImpl;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new RegisterUserController()).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void RegisterUsersTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/RegisterUsers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("RegisterUser"));
    }

    @Test
    public void FindByRegisterUserIdTest() throws Exception {
        RegisterUser registerUser = registerUserRepository.findById(90).get();
        when(registerUserServiceImpl.findByRegisterUserId(90)).thenReturn(registerUser);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/RegisterUser/90"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();

        String expectedJson = "{\"userId\":90,\"name\":\"User90\",\"email\":\"user90@example.com\",\"role\":\"RegisterUser\",\"password\":\"1234\"}";

        assertEquals(expectedJson, responseContent);
    }

    @Test
    void AddRegisterUserTest() throws Exception {
        RegisterUser registerUser = new RegisterUser(90,"User90","user90@example.com","1234");
        String requestBody = objectMapper.writeValueAsString(registerUser);

        MvcResult mvcResult =
                mockMvc.perform(post("/addRegisterUser")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                        .andExpect(status().isOk())
                        .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("User90"));
    }

    @Test
    public void testUpdateRegisterUserSuccess() throws Exception {
        RegisterUser updatedRegisterUser = new RegisterUser(5, "UpdatedUser", "updateduser@example.com","1234");

        when(registerUserServiceImpl.updateRegisterUser(5, updatedRegisterUser)).thenReturn("RegisterUser updated successfully");

        String updatedRegisterUserJson = objectMapper.writeValueAsString(updatedRegisterUser);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/updateRegisterUser/1")
                        .contentType("application/json")
                        .content(updatedRegisterUserJson))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertEquals("RegisterUser updated successfully", responseContent);
    }

    @Test
    public void testDeleteRegisterUser() throws Exception {
        when(registerUserServiceImpl.deleteRegisterUser(90)).thenReturn("RegisterUser deleted successfully");

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteRegisterUser/90"))
                .andExpect(status().isOk())
                .andExpect(content().string("RegisterUser deleted Successfully"));
    }


}