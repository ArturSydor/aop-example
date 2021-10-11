package com.example.aop.aopexample.business;

import org.springframework.stereotype.Service;

@Service
public class Facebook implements Company{
    @Override
    public int getRevenue() {
        return 1;
    }
}
