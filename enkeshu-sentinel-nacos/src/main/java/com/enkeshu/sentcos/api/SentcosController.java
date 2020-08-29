package com.enkeshu.sentcos.api;


import com.enkeshu.sentcos.infra.bean.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/sentcos")
public class SentcosController {

    @GetMapping("/getTest")
    public Result<String> getTest() {
        return new Result<>(UUID.randomUUID().toString());
    }

    @GetMapping("/getExce")
    public Result<Integer> getExce() {
        return new Result<>(1 / 0);
    }
}

