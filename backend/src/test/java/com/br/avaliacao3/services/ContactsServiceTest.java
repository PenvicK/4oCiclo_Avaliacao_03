package com.br.avaliacao3.services;

import com.br.avaliacao3.exceptions.ContactsAlreadyExistsException;
import com.br.avaliacao3.exceptions.ContactsNotFoundException;
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

    @Test
    @DisplayName("Deve retornar sucesso quando buscar um contato")
    public void shouldReturnSuccess_WhenFindContact(){
        ContactsModel contactTest = service.findById(1L);
        Assertions.assertEquals(contactTest.getName(), "John");
    }

    @Test
    @DisplayName("Deve retornar NOT FOUND quando buscar um contato")
    public void shouldReturnNotSuccess_WhenFindContact(){
        Assertions.assertThrows(ContactsNotFoundException.class, () -> service.findById(2L) );
    }

    @Test
    @DisplayName("Deve retornar sucesso quando inserir um contato")
    public void shouldReturnSuccess_WhenInsideContact(){
        ContactsModel contactsTest = new ContactsModel(5L, "Nome", "email@email.com", "0001-0000");
        Assertions.assertDoesNotThrow(() -> service.create(contactsTest) );
    }

    @Test
    @DisplayName("Deve retornar exceptiom quando inserir um contato com o telefone já cadastrado")
    public void shouldReturnException_WhenInsideContactWithExistentTelephone(){
        ContactsModel contactsTest = new ContactsModel(4L, "Nome", "email@email.com", "0000-0000");
        Assertions.assertThrows(ContactsAlreadyExistsException.class, () -> service.create(contactsTest) );
    }

    @Test
    @DisplayName("Deve retornar exceptiom quando inserir um contato com o email já cadastrado")
    public void shouldReturnException_WhenInsideContactWithExistentEmail(){
        ContactsModel contactsTest = new ContactsModel(4L, "Nome", "test@test.com", "1000-0000");
        Assertions.assertThrows(ContactsAlreadyExistsException.class, () -> service.create(contactsTest) );
    }

    @BeforeEach
    public void setup(){
        ContactsModel user = new ContactsModel(1L,"John", "test@test.com", "0000-0000");
        Mockito.when(repository.findById(user.getId())).thenReturn(java.util.Optional.of(user));
    }
}
