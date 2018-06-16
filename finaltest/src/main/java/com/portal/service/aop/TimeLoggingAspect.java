package com.portal.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
//@Aspect
public class TimeLoggingAspect {
//    @Around("execution(* com.portal.service.controller..*.*(..))")
//    public void userAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
//        System.out.println("@Around: Before calculation-"+ new Date());
//        joinPoint.proceed();
//        System.out.println("@Around: After calculation-"+ new Date());
//    }
}