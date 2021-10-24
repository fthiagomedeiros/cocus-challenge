package com.cocus.challenge.fizzbuzz.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzLogicTest {

    private final FizzBuzzLogic fizzBuzzLogic = new FizzBuzzLogic();

    @Test
    public void fizzBuzzThreeMultiple() {
        int value = 3;
        String output = fizzBuzzLogic.playWith(value);
        assertThat(output).isEqualTo("fizz");
    }

    @Test
    public void fizzBuzzFiveMultiple() {
        int value = 5;
        String output = fizzBuzzLogic.playWith(value);
        assertThat(output).isEqualTo("buzz");
    }

    @Test
    public void fizzBuzzThreeFiveMultiple() {
        int value = 15;
        String output = fizzBuzzLogic.playWith(value);
        assertThat(output).isEqualTo("fizzbuzz");
    }

}
