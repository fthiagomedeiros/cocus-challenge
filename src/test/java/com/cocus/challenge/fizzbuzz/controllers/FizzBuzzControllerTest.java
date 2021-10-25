package com.cocus.challenge.fizzbuzz.controllers;

import com.cocus.challenge.fizzbuzz.domain.FizzBuzz;
import com.cocus.challenge.fizzbuzz.dto.FizzBuzzRequest;
import com.cocus.challenge.fizzbuzz.service.FizzBuzzService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@WebFluxTest(FizzBuzzController.class)
@ContextConfiguration(classes = {
        FizzBuzzService.class,
        FizzBuzzController.class,
        FizzBuzz.class
})
public class FizzBuzzControllerTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Value("classpath:fizzbuzz/request/postFizzBuzzValid.json")
    private Resource postFizzBuzz;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void shouldTestValidNumberInRequest() throws Exception {

        //Given the path
        String path = "/fizzbuzz";

        FizzBuzzRequest body = objectMapper.readValue(postFizzBuzz.getInputStream(), FizzBuzzRequest.class);

        val result = webTestClient
                .post()
                .uri(path)
                .body(Mono.just(body), FizzBuzzRequest.class)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody().returnResult();

        String response = new String(Objects.requireNonNull(result.getResponseBody()));
        assertThat(response).isEqualTo("fizzbuzz");
    }

    private static Stream<Arguments> fizzBuzzTestInputs() {
        return Stream.of(
                Arguments.of(3, "fizz"),
                Arguments.of(5, "buzz"),
                Arguments.of(15, "fizzbuzz"),
                Arguments.of(1, "1")
        );
    }

    @ParameterizedTest(name = "For {0} result is {1}")
    @MethodSource("fizzBuzzTestInputs")
    public void shouldTestSeveralValues(int number, String result) throws Exception {

        //Given the path
        String path = "/fizzbuzz";

        FizzBuzzRequest body = FizzBuzzRequest.builder().number(number).build();

        val response = webTestClient
                .post()
                .uri(path)
                .body(Mono.just(body), FizzBuzzRequest.class)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody().returnResult();

        String output = new String(Objects.requireNonNull(response.getResponseBody()));
        assertThat(output).isEqualTo(result);
    }

}
