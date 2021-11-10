package com.br.avaliacao3.controllers;

import com.br.avaliacao3.models.ContactsModel;
import com.br.avaliacao3.services.ContactsService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/contacts")
public class ContactsController {

    @Autowired
    private ContactsService service;

    @GetMapping
    public ResponseEntity<List<ContactsModel>> index(){
        List<ContactsModel> list = service.index();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ContactsModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(path = "/{email}")
    public ResponseEntity<ContactsModel> show(@PathVariable String email) {
        return ResponseEntity.ok(service.show(email));
    }

    @PostMapping
    public ResponseEntity<ContactsModel> create(@RequestBody ContactsModel entity) {
        try {
            ContactsModel obj = service.create(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("User " + id + " deleted!");
    }
}
