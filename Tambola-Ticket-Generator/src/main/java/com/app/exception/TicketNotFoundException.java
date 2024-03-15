package com.app.exception;

public class TicketNotFoundException  extends RuntimeException{
    public TicketNotFoundException(String msg){
        super(msg);
    }
    public TicketNotFoundException(){
        super("Not Found!!!");
    }
}
