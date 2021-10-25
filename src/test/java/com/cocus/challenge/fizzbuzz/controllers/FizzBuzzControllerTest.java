package com.cocus.challenge.fizzbuzz.controllers;

import com.cocus.challenge.fizzbuzz.dto.FizzBuzzRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class FizzBuzzControllerTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Value("classpath:fizzbuzz/request/postFizzBuzzValid.json")
    private Resource postFizzBuzz;

    @Test
    public void shouldTestValidNumberInRequest() throws IOException {

        //Given the path
        String path = "/fizzbuzz";

        FizzBuzzRequest body = objectMapper.readValue(postFizzBuzz.getInputStream(), FizzBuzzRequest.class);


    }

}
