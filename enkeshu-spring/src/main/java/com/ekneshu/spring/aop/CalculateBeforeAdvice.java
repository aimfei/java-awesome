package com.ekneshu.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Method;


public class CalculateBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method.getName());
    }
}