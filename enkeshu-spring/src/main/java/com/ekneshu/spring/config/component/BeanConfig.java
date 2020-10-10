package com.ekneshu.spring.config.component;

import com.ekneshu.spring.bean.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {


    @Bean("account")
    public Account setAccount() {
        Account account = new Account();
        account.setAge(11);
        account.setName("zhangsan");
        return account;
    }
}
