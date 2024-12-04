package com.supra.petdb;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class Aspects {
    @After(value = "execution(* findAll(..))")
    public void afterFindAll(JoinPoint jp) {
        log.info("{}", jp.getSignature().getName());
    }
}
