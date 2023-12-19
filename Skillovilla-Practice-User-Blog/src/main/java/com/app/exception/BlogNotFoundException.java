package com.app.exception;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String msg){
        super(msg);
    }
    public BlogNotFoundException(){
        super("Blog Not Found!");
    }
}
