package com.br.avaliacao3.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ContactsAlreadyExistsException extends ServiceException {
    public ContactsAlreadyExistsException(String message) {
        super(message);
    }
}
