package com.example.aop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.example.aop.aopexample.business.*.*(..))")
    public void businessLogicExecution() {
    }

    @Pointcut("execution(* com.example.aop.aopexample.data.*.*(..))")
    public void dataLayerExecution() {
    }

    // Allows to combine two PointCuts with &&
    @Pointcut("com.example.aop.aopexample.aspects.CommonPointCutConfig.dataLayerExecution() &&" +
            "com.example.aop.aopexample.aspects.CommonPointCutConfig.businessLogicExecution()")
    public void allLayersExecution() {
    }

    // Will be executed for all beans which names are ending with 'Repository' prefix
    @Pointcut("bean(*Repository)")
    public void repositoryBeans() {
    }

    // Intercept all the calls within this package
    // when using within(package) * is not needed, with execution(* package) star is needed
    @Pointcut("within(com.example.aop.aopexample.business..*)")
    public void businessLayerExecutionWithWithin() {
    }

    @Pointcut("@annotation(com.example.aop.aopexample.aspects.TrackTime)")
    public void trackTimeForMethodsMarkedWithAnnotation() {
    }

}
