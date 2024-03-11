package com.myblog.myblog1.exception;

import org.springframework.web.bind.annotation.ResponseStatus;


public class ResourceNotFoundException extends RuntimeException{//    Respurce not found class
    //
    //    if the Id is  found then show the details if not then show id not avaliable

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
