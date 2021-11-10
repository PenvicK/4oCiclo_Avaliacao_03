package com.br.avaliacao3.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactsNotFoundException extends ServiceException {

    public ContactsNotFoundException(String message) {
        super(message);
    }
}
