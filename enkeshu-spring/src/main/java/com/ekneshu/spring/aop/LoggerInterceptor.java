package com.ekneshu.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class LoggerInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println( getClass()+"MethodInterceptor start");
        System.out.println("exec method"+methodInvocation.getMethod());
        Object result = methodInvocation.proceed();
        System.out.println("执行结果="+result);
        System.out.println(getClass()+"MethodInterceptor stop");
        return result;
    }
}
