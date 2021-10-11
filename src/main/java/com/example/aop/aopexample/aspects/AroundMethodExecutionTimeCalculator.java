package com.example.aop.aopexample.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class AroundMethodExecutionTimeCalculator {

    @Around("execution(* com.example.aop.aopexample.business.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // executes intercepted method
        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;

        log.info("{} execution time = {}", joinPoint.toShortString(), duration);

        return result;
    }

}
