package com.doorstep.api.exceptions;

public class EntityAlreadyExistsException extends RuntimeException{

    public EntityAlreadyExistsException(String message){
        super(message);
    }

}

