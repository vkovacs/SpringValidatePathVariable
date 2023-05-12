package com.example.demo.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated //https://www.codejava.net/frameworks/spring-boot/rest-api-validate-path-variables-examples
public class UserController {

    @GetMapping("/users/{id}")
    public String getUserById(
            @Size(min = 2, max = 20, message = "ID length must be between 2 and 20 characters")
            @PathVariable("id") String id
    ) {
        // Your logic here
        return "";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleConstraintViolationException(){}
}