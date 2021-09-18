package com.enkeshu.webflux;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;

@SpringBootApplication
@RestController
public class EnkeshuWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnkeshuWebfluxApplication.class, args);
    }



}
