package com.ekneshu.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AopConfig.class);
        applicationContext.refresh();

        Calculate calculate = (Calculate) applicationContext.getBean("calculateProxy");
        calculate.add(1,3);

        System.out.println("=============");
        calculate.div(30,4);
    }
}
