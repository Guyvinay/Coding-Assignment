package com.app.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg){
        super(msg);
    }
    public UserNotFoundException(){
        super("User Not found!");
    }
}
