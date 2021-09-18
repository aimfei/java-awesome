package com.enkeshu.oracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EnkeshuOracleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnkeshuOracleApplication.class, args);
    }

}
