package com.br.avaliacao3.repositories;

import com.br.avaliacao3.models.ContactsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactsRepository extends JpaRepository<ContactsModel, Long> {
    Optional<ContactsModel> findByEmail(String email);
    Optional<ContactsModel> findByTelephone(String telephone);
}
