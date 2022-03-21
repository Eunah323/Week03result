package com.sparta.chapter03result;

import com.sparta.chapter03result.domain.DiaryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Chapter03resultApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter03resultApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(DiaryRepository repository) {
        return (args) -> {

        };
    }
}
