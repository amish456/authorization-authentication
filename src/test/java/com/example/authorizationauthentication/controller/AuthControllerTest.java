package com.example.authorizationauthentication.controller;

import com.example.authorizationauthentication.entity.Role;
import com.example.authorizationauthentication.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;

class AuthControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void authenticateUser() {

    }

    @Test
    void registerUser() throws Exception {
        Role role = new Role(1, "ROLE_ADMIN");
        Set<Role> roles = new HashSet<>();
        roles.add(role);


        User user = new User(1, "Amish", "amish", "amish@gmail.com", "amish", roles);
//        String name = "Amish";
//        String username = "amish";
//        String email = "amish@gmail.com";
//        String password = "amish";
        String json = json(user);
        mvc.perform(
                MockMvcRequestBuilders.post("/api/auth/signup")
                        .content(String.valueOf(json))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", CoreMatchers.is(Boolean.TRUE)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.token", CoreMatchers.notNullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data.user", CoreMatchers.is(user)));

    }

    private String json(User user) throws JsonProcessingException{
        return mapper.writeValueAsString(user);
    }
}