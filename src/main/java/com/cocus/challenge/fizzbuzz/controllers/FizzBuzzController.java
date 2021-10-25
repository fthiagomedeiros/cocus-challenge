package com.cocus.challenge.fizzbuzz.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

    @GetMapping(value = "fizzbuzz")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @PostMapping(value = "fizzbuzz")
    public ResponseEntity<String> postFizzBuzz() {
        return new ResponseEntity<>("fizz", HttpStatus.OK);
    }

}
