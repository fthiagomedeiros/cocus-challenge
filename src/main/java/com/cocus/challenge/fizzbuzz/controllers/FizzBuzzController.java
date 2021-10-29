package com.cocus.challenge.fizzbuzz.controllers;

import com.cocus.challenge.fizzbuzz.dto.FizzBuzzRequest;
import com.cocus.challenge.fizzbuzz.dto.FizzBuzzResponse;
import com.cocus.challenge.fizzbuzz.service.FizzBuzzService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FizzBuzzController {

    private final static String PATH = "/fizzbuzz";
    private final static String HEALTH = "/health";

    private final FizzBuzzService service;

    @GetMapping(value = "/")
    public ResponseEntity<FizzBuzzResponse> getHealthDefault() {
        return new ResponseEntity<>(FizzBuzzResponse.builder()
                .result("Health").build(), HttpStatus.OK);
    }

    @GetMapping(value = HEALTH)
    public ResponseEntity<FizzBuzzResponse> getHealth() {
        return new ResponseEntity<>(FizzBuzzResponse.builder()
                .result("Health").build(), HttpStatus.OK);
    }

    @PostMapping(value = PATH)
    public ResponseEntity<FizzBuzzResponse> postFizzBuzz(@RequestBody FizzBuzzRequest body) {
        String response;

        try {
            response = service.play(body.getNumber());
        } catch (Exception ex) {
            return new ResponseEntity<>(FizzBuzzResponse.builder()
                    .result("Invalid Input").build(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(FizzBuzzResponse.builder()
                .result(response).build(), HttpStatus.OK);
    }

}
