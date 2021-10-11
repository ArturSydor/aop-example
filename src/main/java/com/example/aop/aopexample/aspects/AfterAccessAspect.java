package com.example.aop.aopexample.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class AfterAccessAspect {

    @AfterReturning(value = "execution(* com.example.aop.aopexample.business.*.*(..))",
            returning = "result")
    public void afterExecution(JoinPoint joinPoint, Object result) {
        log.info("Checking return value={} after {} was executed", result, joinPoint.toShortString());
    }

    @AfterThrowing(value = "execution(* com.example.aop.aopexample.business.*.*(..))",
            throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.warn("{} throws an exception with message {}", joinPoint.toShortString(), exception.getMessage());
    }

    @After("execution(* com.example.aop.aopexample.business.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("{} was executed", joinPoint.toShortString());
    }
}
