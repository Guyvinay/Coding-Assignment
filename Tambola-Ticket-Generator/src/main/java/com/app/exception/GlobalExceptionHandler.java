package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDefinition> globalExceptionHandle(Exception ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefinition>(
				new ExceptionDefinition(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
				),
				HttpStatus.BAD_REQUEST
		);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionDefinition> noHandlerFoundException(NoHandlerFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefinition>(
				new ExceptionDefinition(
						LocalDateTime.now(),
						"There is no handler for this endpoint: " + wb.getDescription(false),
						ex.getMessage()
				),
				HttpStatus.BAD_REQUEST
		);
	}
	
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<ExceptionDefinition> notFoundExceptionHandler(TicketNotFoundException ex, WebRequest wb){
		return new ResponseEntity<ExceptionDefinition>(
				new ExceptionDefinition(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
				),
				HttpStatus.BAD_REQUEST
		);
	}

}
