package com.br.avaliacao3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_contacts")
public class ContactsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;

    public ContactsModel(ContactsModel entity){
        name = entity.getName();
        email = entity.getEmail();
        telephone = entity.getTelephone();
    }
}
