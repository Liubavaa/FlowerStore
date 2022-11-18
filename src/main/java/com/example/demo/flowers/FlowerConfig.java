package com.example.demo.flowers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FlowerConfig {

    @Bean
    CommandLineRunner commandLineRunner(FlowerRepository repository){
        return args -> {
            Flower blue = new Flower(1L, 100, FlowerColor.YELLOW, 100, FlowerType.TULIP);
            Flower red = new Flower(2L, 50, FlowerColor.RED, 50, FlowerType.ROSE);
            repository.saveAll(List.of(blue, red));
        };
    }
}
