package com.enkeshu.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SpringBootApplication
@RestController
public class EnkeshuWebmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnkeshuWebmvcApplication.class, args);
    }

    @GetMapping("hello")
    public String  world(HttpServletRequest request, @RequestHeader("Authorization")String auth, @RequestParam("order")String order){
        return String.format("URI:%s - Order = %s  authorization=%s", request.getRequestURI(), order,auth);
    }

    @PostMapping("hello1")
    public String  hello1(@RequestBody Map map){
        return String.format("URI:%s - Order = %s  authorization=%s", 1, 1,1);
    }


}
