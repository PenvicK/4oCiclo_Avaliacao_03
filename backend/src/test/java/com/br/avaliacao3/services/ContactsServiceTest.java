package com.br.avaliacao3.services;

import com.br.avaliacao3.models.ContactsModel;
import com.br.avaliacao3.services.ContactsService;
import com.br.avaliacao3.repositories.ContactsRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContactsServiceTest {

    @Autowired
    ContactsService service;


    @MockBean
    ContactsRepository repository;


    @BeforeEach
    public void setup(){
        ContactsModel user = new ContactsModel(1L,"John", "test@test.com", "0000-0000");
        Mockito.when(repository.findById(user.getId())).thenReturn(java.util.Optional.of(user));
    }
}
