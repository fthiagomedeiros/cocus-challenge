package com.cocus.challenge.fizzbuzz.config;

import com.cocus.challenge.fizzbuzz.domain.FizzBuzz;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FizzBuzzConfiguration {

    @Bean
    public FizzBuzz fizzBuzzLogic() {
        return new FizzBuzz();
    }

}
