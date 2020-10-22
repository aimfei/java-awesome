package com.ekneshu.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ekneshu.spring.bean")
public class BeanConfig {

    @Bean("personal")
    public PersonalFactoryBean proxyFactoryBean() {
        return new PersonalFactoryBean();
    }

    @Bean("account")
    public Account setAccount() {
        Account account = new Account();
        account.setAge(11);
        account.setName("zhangsan");
        return account;
    }
}
