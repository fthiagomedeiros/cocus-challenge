package com.cocus.challenge.fizzbuzz.service;

import com.cocus.challenge.fizzbuzz.domain.FizzBuzz;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FizzBuzzService {

    private final FizzBuzz fizzBuzz;

    public String play(int number) {
        return fizzBuzz.playWith(number);
    }

}
