package com.example.aop.aopexample.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Slf4j
// Aspect is a combination of Pointcut and Advice
@Aspect
@Configuration
public class DummyAuthBeforeAspect {

    /**
     * execution(*(any written type) PACKAGE.CLASS.METHOD(..))
     * * == any
     *
     * @param joinPoint input params of method that is executed
     */
    @Before("com.example.aop.aopexample.aspects.CommonPointCutConfig.businessLogicExecution()")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("Authorisation for {}", joinPoint.toShortString());
    }

    // Will be executed before all methods in com.example.aop.aopexample
    // This expression is called Pointcut
    @Before("execution(* com.example.aop.aopexample..*.*(..))")
    // JoinPoint is specific(intercepted) execution instance
    // Weaving - processing of implementing AOP around method
    // Weaver - framework that implements weaving
    public void beforeAllMethodsInPackage(JoinPoint joinPoint) {
        // logic inside is called advice
        log.info("Authorisation for {}", joinPoint.toShortString());
    }

    @Before("com.example.aop.aopexample.aspects.CommonPointCutConfig.dataLayerExecution()")
    public void beforeRepositoryCalled(JoinPoint joinPoint) {
        log.info("Auth before calling {}", joinPoint.toShortString());
    }


}
