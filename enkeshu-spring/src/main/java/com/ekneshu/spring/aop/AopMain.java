package com.ekneshu.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AopConfig.class);
        applicationContext.refresh();

        Calculate calculate = (Calculate) applicationContext.getBean("calculateProxy");
        //System.out.println(calculate);
        System.out.println(calculate.add(1,3));
    }
}
