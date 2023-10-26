package com.sda.MidProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.repository.AdminRepository;
import com.sda.MidProject.service.implementations.AdminServiceImpl;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AdminControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AdminRepository adminRepository;

    @Mock
    private AdminServiceImpl adminServiceIml;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new AdminController()).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void adminsTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/Admins"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Admin1"));
    }

    @Test
    public void FindByAdminIdTest() throws Exception {
        Admin admin = adminRepository.findById(1).get();
        when(adminServiceIml.findByAdminId(1)).thenReturn(admin);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/Admin/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();

        String expectedJson = "{\"userId\":1,\"name\":\"Admin1\",\"email\":\"admin1@example.com\",\"role\":\"Admin\"}";

        assertEquals(expectedJson, responseContent);
    }

    @Test
    void AddAdminTest() throws Exception {
        Admin admin = new Admin(12,"Admin12","admin12@example.com","1234");
        String requestBody = objectMapper.writeValueAsString(admin);

        MvcResult mvcResult =
                mockMvc.perform(post("/addAdmin")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                        .andExpect(status().isOk())
                        .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Admin12"));
    }

    @Test
    public void testDeleteAdmin() throws Exception {
        when(adminServiceIml.deleteAdmin(1)).thenReturn("Admin deleted successfully");

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteAdmin/11"))
                .andExpect(status().isOk())
                .andExpect(content().string("Admin deleted Successfully"));
    }

}