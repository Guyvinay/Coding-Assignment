package com.app.exception;

public class InvalidCredsException extends RuntimeException {
    public InvalidCredsException(String msg){
        super(msg);
    }
    public InvalidCredsException(){
        super("Invalid Credentials");
    }
}
