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

    @AfterReturning(value = "com.example.aop.aopexample.aspects.CommonPointCutConfig.businessLogicExecution()",
            returning = "result")
    public void afterExecution(JoinPoint joinPoint, Object result) {
        log.info("Checking return value={} after {} was executed", result, joinPoint.toShortString());
    }

    @AfterThrowing(value = "com.example.aop.aopexample.aspects.CommonPointCutConfig.businessLogicExecution()",
            throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.warn("{} throws an exception with message {}", joinPoint.toShortString(), exception.getMessage());
    }

    @After("com.example.aop.aopexample.aspects.CommonPointCutConfig.businessLogicExecution()")
    public void after(JoinPoint joinPoint) {
        log.info("{} was executed", joinPoint.toShortString());
    }
}
