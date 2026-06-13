package com.nara.auth_service.config;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeHandler(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    } 

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> badCredHandler(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    } 

}
