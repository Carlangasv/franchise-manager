package com.franchise.manager.exceptionHandling;

import com.franchise.manager.exception.FranchiseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(FranchiseNotFoundException.class)
    public ResponseEntity<Response> handleException(FranchiseNotFoundException e) {
        Response response = new Response(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
