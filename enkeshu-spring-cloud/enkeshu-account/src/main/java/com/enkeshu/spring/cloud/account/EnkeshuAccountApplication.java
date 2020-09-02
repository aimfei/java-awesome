package com.enkeshu.spring.cloud.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.enkeshu.spring.cloud.account.infra.mapper")
public class EnkeshuAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnkeshuAccountApplication.class, args);
    }

}
