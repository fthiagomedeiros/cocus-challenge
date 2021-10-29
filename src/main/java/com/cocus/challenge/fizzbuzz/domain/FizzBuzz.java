package com.cocus.challenge.fizzbuzz.domain;

public class FizzBuzz {

    private static final int IS_MULTIPLE_OF_3 = 3;
    private static final int IS_MULTIPLE_OF_5 = 5;

    public String playWith(int number) {

        if (number % IS_MULTIPLE_OF_3 == 0 && number % IS_MULTIPLE_OF_5 == 0) {
            return "fizzbuzz";
        }

        if (number % IS_MULTIPLE_OF_3 == 0) {
            return "fizz";
        }

        if (number % IS_MULTIPLE_OF_5 == 0) {
            return "buzz";
        }

        return String.valueOf(number);
    }
}
