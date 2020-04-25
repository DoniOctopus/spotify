package com.enigma.excercise.spotify.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends  RuntimeException{

    public ResourceNotFoundExeption(String id, Object object){
        super("Resource with id =" +id+" of class" +object.getClass()+" NotFound");
    }

}

