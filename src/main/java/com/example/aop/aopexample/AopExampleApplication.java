package com.example.aop.aopexample;

import com.example.aop.aopexample.business.Company;
import com.example.aop.aopexample.data.DummyRepository;
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

    private final DummyRepository dummyRepository;

    public static void main(String[] args) {
        SpringApplication.run(AopExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            log.info("Apple revenue = {}", apple.getRevenue());
            log.info("Facebook revenue = {}", facebook.getRevenue());
            log.info("Data retrieved by Dummy repository = {}", dummyRepository.getInfo());

            amazon.getRevenue();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
