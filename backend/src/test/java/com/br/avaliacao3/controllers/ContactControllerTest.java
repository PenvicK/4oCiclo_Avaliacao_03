package com.br.avaliacao3.controllers;

import com.br.avaliacao3.models.ContactsModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContactControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ContactsController controller;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Deve retornar status code 201 quando criar contato com dados corretos")
    public void shouldReturnStatusCode201_WhenCreateContactWithCorrectData() throws Exception {
        ContactsModel user = new ContactsModel(1L, "John", "email@email.com", "1234");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Deve retornar status code 400 quando criar usuario com dados incorretos")
    public void shouldReturnStatusCode400_WhenCreateUserWithIncorrectData() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar status code 422 quando criar contato com email existente")
    public void shouldReturnStatusCode422_WhenCreateContactWithExistentEmail() throws Exception {
        ContactsModel existingContact = new ContactsModel(1L, "John", "email@email.com", "1234");
        ContactsModel contact = new ContactsModel(1L, "Doe", "email@email.com", "12345");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(existingContact);
        String json2 = mapper.writeValueAsString(contact);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json2))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    @DisplayName("Deve retornar status code 422 quando criar contato com email existente")
    public void shouldReturnStatusCode422_WhenCreateContactWithExistentTelephone() throws Exception {
        ContactsModel existingContact = new ContactsModel(1L, "John", "email@email.com", "1234");
        ContactsModel contact = new ContactsModel(1L, "Doe", "test@email.com", "1234");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(existingContact);
        String json2 = mapper.writeValueAsString(contact);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json2))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    @DisplayName("Deve retornar status code 200 quando buscar contato existente pelo ID")
    public void shouldReturnStatusCode200_WhenSearchExistingContactByID() throws Exception {
        ContactsModel user = new ContactsModel(1L, "John", "email2@email.com", "12345");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/contacts/id/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Deve retornar status code 200 quando buscar contato existente pelo email")
    public void shouldReturnStatusCode200_WhenSearchExistingContactByEmail() throws Exception {
        ContactsModel user = new ContactsModel(1L, "John", "email3@email.com", "123456");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/contacts/email/email3@email.com"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
