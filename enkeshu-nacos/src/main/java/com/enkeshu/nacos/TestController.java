package com.enkeshu.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/4/26
 **/
@RestController
@RequestMapping("/nacos")
@RefreshScope
public class TestController {

    @Value("${username:1}")
    private String username;

    @Value("${password:1}")
    private String password;

    @RequestMapping("/test1")
    public Object getTest() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("username", username);
        objectObjectHashMap.put("password", password);
        return objectObjectHashMap;
    }
}
