package com.enkeshu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class RequestAop {

    @Before("execution(* com.enkeshu.aop.service.AopService.*(..))")
    public void start(){
        System.out.println("start RequestAop");
    }

    @After("execution(* com.enkeshu.aop.service.*.*(..))")
    public void stop(){
        System.out.println("stop RequestAop");
    }
}
