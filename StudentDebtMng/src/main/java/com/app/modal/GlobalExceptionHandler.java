package com.app.modal;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

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

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionDetails> noHandlerFoundException(NoHandlerFoundException ex , WebRequest wb){
		return new ResponseEntity<ExceptionDetails>(
				new ExceptionDetails(
						LocalDateTime.now(),
						ex.getMessage(),
						wb.getDescription(false)
				),
				HttpStatus.BAD_REQUEST
		);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDetails> methodArgumentNotValidException(
			MethodArgumentNotValidException ex ,
			WebRequest wb){
//		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
//		List<String> errorsList = MethodArgumentNotValidException.errorsToStringList(errors);
		return new ResponseEntity<ExceptionDetails>(
				new ExceptionDetails(
						LocalDateTime.now(),
//						String.join(", ",errorsList),
						ex.getMessage(),
						wb.getDescription(false)
				),
				HttpStatus.BAD_REQUEST
		);
	}
}
