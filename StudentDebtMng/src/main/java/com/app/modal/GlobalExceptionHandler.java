package com.app.modal;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> GlobalExceptionHandler(Exception ex , WebRequest wb){
		return new ResponseEntity<ExceptionDetails>(
				new ExceptionDetails(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.BAD_REQUEST
				);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ExceptionDetails> studentNotFoundException(StudentNotFoundException ex , WebRequest wb){
		return new ResponseEntity<ExceptionDetails>(
				new ExceptionDetails(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND
				);
	}
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<ExceptionDetails> paymentNotFoundException(PaymentNotFoundException ex , WebRequest wb){
		return new ResponseEntity<ExceptionDetails>(
				new ExceptionDetails(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
						),
				HttpStatus.NOT_FOUND
				);
	}
}
