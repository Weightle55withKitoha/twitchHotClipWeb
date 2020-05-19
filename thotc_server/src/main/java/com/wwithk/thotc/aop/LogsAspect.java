package com.wwithk.thotc.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogsAspect {

    @Around("execution(* com.wwithk.thotc.controller..*.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        log.info("start package= " +pjp.getSignature().getDeclaringTypeName() + " method= "+ pjp.getSignature().getName());
        Object result=pjp.proceed();
        log.info("finished package= " +pjp.getSignature().getDeclaringTypeName() + " method= "+ pjp.getSignature().getName());

        return result;
    }
}
