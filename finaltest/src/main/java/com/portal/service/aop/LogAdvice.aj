package com.portal.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAdvice {
    private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

    //@Before:앞에실행 @After:뒤에실행 @Around:앞뒤다실행   *(..) 모든 메소드
    @Around("execution(* com.portal.service.controller.*.*(..))"
            + " or execution(* com.portal.service..*Impl.*(..))"
            + " or execution(* com.portal.service..dao.*Impl.*(..))")
    public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("시작");
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); //핵심업무 실행
        System.out.println("중간");

        //호출한 클래스 이름
        String type = joinPoint.getSignature().getDeclaringTypeName();
        String name = "";
        if (type.contains("Controller")) {
            name = "Controller \t:";
        } else if (type.contains("Service")) {
            name = "ServiceImpl \t:";
        } else if (type.contains("DAO")) {
            name = "DAOImpl \t:";
        }
        //호출한 클래스, method 정보
        logger.info(name + type + "." + joinPoint.getSignature().getName() + "()");
        //method에 전달되는 매개변수들
        logger.info(Arrays.toString(joinPoint.getArgs()));
        long end = System.currentTimeMillis();
        long time = end - start;
        logger.info("실행시간:" + time);
        return result;
    }
}