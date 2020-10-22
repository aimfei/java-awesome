package com.ekneshu.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanSrv {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

        Object object = applicationContext.getBean("personal");
        System.out.println(object);
    }
}
