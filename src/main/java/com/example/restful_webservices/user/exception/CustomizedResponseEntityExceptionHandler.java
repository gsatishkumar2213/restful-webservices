package com.example.restful_webservices.user.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * Created by gsati on 8/23/2018.
 */
@ControllerAdvice()
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
       ResponseResource responseResource=
               new ResponseResource(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(responseResource, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundEception.class)
    public final ResponseEntity<Object> handleNotFoundException(UserNotFoundEception ex, WebRequest request) throws Exception {
        ResponseResource responseResource=
                new ResponseResource(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(responseResource, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


        ResponseResource responseResource=
                new ResponseResource
                        (new Date(),"name must be more than 2 characters",ex.getBindingResult().toString());
        return new ResponseEntity(responseResource, HttpStatus.BAD_REQUEST);
    }

}
