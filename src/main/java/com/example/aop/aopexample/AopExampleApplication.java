package com.example.aop.aopexample;

import com.example.aop.aopexample.business.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class AopExampleApplication implements CommandLineRunner {

    // No qualifier is needed, because Spring autowires correct bean by FIELD name.
    private final Company apple;

    private final Company facebook;

    private final Company amazon;

    public static void main(String[] args) {
        SpringApplication.run(AopExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            log.info("Apple revenue = {}", apple.getRevenue());
            log.info("Facebook revenue = {}", facebook.getRevenue());
            amazon.getRevenue();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
