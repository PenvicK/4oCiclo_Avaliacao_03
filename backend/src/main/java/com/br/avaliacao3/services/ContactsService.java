package com.br.avaliacao3.services;

import com.br.avaliacao3.exceptions.ContactsAlreadyExistsException;
import com.br.avaliacao3.exceptions.ContactsNotFoundException;
import com.br.avaliacao3.models.ContactsModel;
import com.br.avaliacao3.repositories.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactsService {

    @Autowired
    private ContactsRepository repository;

    public List<ContactsModel> index() {
        List<ContactsModel> result = repository.findAll();
        return result.stream().map(x -> new ContactsModel(x)).collect(Collectors.toList());
    }

    public ContactsModel findById(Long id) {
        Optional<ContactsModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ContactsNotFoundException("Contact not found. Please try again."));
    }

    public ContactsModel show(String email){
        Optional<ContactsModel> result = repository.findByEmail(email);
        return result.orElseThrow(() -> new ContactsNotFoundException("Contact not found. Please try again."));
    }

    public ContactsModel create(ContactsModel contacts){

        Optional<ContactsModel> contactsEmail = repository.findByEmail(contacts.getEmail());
        if(contactsEmail.isPresent()){
            throw new ContactsAlreadyExistsException("Contacts already exists");
        }
        Optional<ContactsModel> contactsTelephone = repository.findByTelephone(contacts.getTelephone());
        if(contactsTelephone.isPresent()){
            throw new ContactsAlreadyExistsException("Contacts already exists");
        }

        ContactsModel unit = new ContactsModel();
        unit.setName(contacts.getName());
        unit.setTelephone(contacts.getTelephone());
        unit.setEmail(contacts.getEmail());

        unit = repository.save(unit);

        return unit;
    }

    public ContactsModel update(Long id, ContactsModel update){
        ContactsModel updated = findById(id);

        updated.setName(update.getName());
        updated.setEmail(update.getEmail());
        updated.setTelephone(update.getTelephone());

        repository.save(updated);

        return updated;
    }

    public void delete(Long id){
        repository.delete(findById(id));
    }
}
