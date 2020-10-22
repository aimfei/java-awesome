package com.ekneshu.spring;

import com.ekneshu.spring.bean.Account;
import com.ekneshu.spring.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringSrv {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringConfig.class);
        Account account= (Account) applicationContext.getBean("account");
        applicationContext.refresh();

        /*Account account= (Account) applicationContext.getBean("account");
        System.out.println(account.getAge()) ;
        account.setAge(12);
        Account account1= (Account) applicationContext.getBean("account");
        System.out.println(account1.getAge());*/

    }
}
