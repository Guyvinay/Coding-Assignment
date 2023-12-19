package com.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDefinition> globalExpHandler(Exception ex, WebRequest wb){
        log.info("Exception From Exception.class");
        return new ResponseEntity<ExceptionDefinition>(
                new ExceptionDefinition(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        wb.getDescription(false)
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDefinition> userNotFoundException(UserNotFoundException ex, WebRequest wb){
        log.info("Exception From UserNotFoundException.class");
        return new ResponseEntity<ExceptionDefinition>(
                new ExceptionDefinition(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        wb.getDescription(false)
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ExceptionDefinition> blogNotFoundException(BlogNotFoundException ex, WebRequest wb){
        log.info("Exception From BlogNotFoundException.class");
        return new ResponseEntity<ExceptionDefinition>(
                new ExceptionDefinition(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        wb.getDescription(false)
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionDefinition> noHandlerFoundException(NoHandlerFoundException ex, WebRequest wb){
        log.info("Exception From NoHandlerFoundException.class");
        return new ResponseEntity<ExceptionDefinition>(
                new ExceptionDefinition(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        wb.getDescription(false)
                ),
                HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDefinition> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest wb){
        log.info("Exception From MethodArgumentNotValidException.class");
        
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        List<String>      errorMessages = MethodArgumentNotValidException.errorsToStringList(allErrors);
//        System.out.println(errorMessages);
        
        return new ResponseEntity<ExceptionDefinition>(
                new ExceptionDefinition(
                        LocalDateTime.now(),
                        String.join(", ", errorMessages),
                        wb.getDescription(false)
                ),
                HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler(InvalidCredsException.class)
    public ResponseEntity<ExceptionDefinition> invalidCredentialsException(InvalidCredsException ex, WebRequest wb){
        log.info("Exception From InvalidCredsException.class");
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
