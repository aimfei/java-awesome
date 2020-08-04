package com.enkeshu.springbootdyncdata.controller;

import com.enkeshu.springbootdyncdata.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/getObj")
    public Object getObj() {
        return testService.getObj();
    }

    @GetMapping("/getObj1")
    public Object getObj1() {
        return testService.getObj1();
    }
}
