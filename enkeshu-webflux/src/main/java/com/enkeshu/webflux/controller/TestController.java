package com.enkeshu.webflux.controller;

import com.enkeshu.webflux.ApiData;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Null;

/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/5/28
 **/
@RestController
public class TestController {
    @PostMapping("/post")
    public ApiData post(@Valid @RequestBody User user){
        System.out.println(user);
        return new ApiData();
    }

    @GetMapping("/get")
    public ApiData get(){
        System.out.println(1/0);
        return new ApiData();
    }

    @Data
    public class User{

        @Null(message = "姓名不能为空")
        private String username;

    }
}
