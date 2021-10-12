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

    @Around("com.example.aop.aopexample.aspects.CommonPointCutConfig.businessLogicExecution()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // executes intercepted method
        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;

        log.info("{} execution time = {}", joinPoint.toShortString(), duration);

        return result;
    }


    @Around("com.example.aop.aopexample.aspects.CommonPointCutConfig.trackTimeForMethodsMarkedWithAnnotation()")
    public Object aroundMarkedMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // executes intercepted method
        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - start;

        log.info("{} execution time = {} p.s Measured only for methods marked with @TrackTime", joinPoint.toShortString(), duration);

        return result;


    }

}
