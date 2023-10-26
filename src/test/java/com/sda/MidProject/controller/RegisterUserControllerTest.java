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


}