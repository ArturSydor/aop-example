package com.example.aop.aopexample.business;

import org.springframework.stereotype.Component;

@Component
public class Amazon implements Company {
    @Override
    public int getRevenue() {
        throw new RuntimeException("Amazon is not implemented yet!");
    }
}
