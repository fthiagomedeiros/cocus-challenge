package com.cocus.challenge.fizzbuzz.controllers;

import com.cocus.challenge.fizzbuzz.dto.FizzBuzzRequest;
import com.cocus.challenge.fizzbuzz.dto.FizzBuzzResponse;
import com.cocus.challenge.fizzbuzz.service.FizzBuzzService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FizzBuzzController {

    private final FizzBuzzService service;

    @PostMapping(value = "/fizzbuzz")
    public ResponseEntity<FizzBuzzResponse> postFizzBuzz(@RequestBody FizzBuzzRequest body) {
        String response = service.play(body.getNumber());
        return new ResponseEntity<>(FizzBuzzResponse.builder()
                .result(response).build(), HttpStatus.OK);
    }

}
