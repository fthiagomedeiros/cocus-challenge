package com.cocus.challenge.fizzbuzz.domain;

public class FizzBuzzLogic {

    public String playWith(int number) {
        String output = String.valueOf(number);

        if (number % 3 == 0) {
            output = "fizz";
        }

        if (number % 3 == 0 && number % 5 == 0) {
            output += "buzz";
            return output;
        }

        if (number % 5 == 0) {
            output = "buzz";
        }

        return output;
    }
}
