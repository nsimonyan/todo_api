package com.nsimonyan.todo.todoapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseController {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> baseExceptionHandling(Throwable t){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t.getMessage());
    }
}
