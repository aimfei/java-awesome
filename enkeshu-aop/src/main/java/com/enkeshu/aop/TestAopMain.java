package com.enkeshu.aop;

import com.enkeshu.aop.service.AopService;

public class TestAopMain {
    public static void main(String[] args) {
        AopService aopService=new AopService();
        aopService.aopMethod();
    }
}
