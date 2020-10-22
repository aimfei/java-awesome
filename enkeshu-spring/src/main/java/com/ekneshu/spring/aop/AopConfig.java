package com.ekneshu.spring.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.ekneshu.spring.aop")
public class AopConfig {

    @Bean(name = "calculate")
    public Calculate calculate() {
        return new Calculate();
    }

    @Bean("loggerInterceptor")
    public LoggerInterceptor loggerInterceptor() {
        return new LoggerInterceptor();
    }

    @Bean
    public CalculateBeforeAdvice calculateBeforeAdvice() {
        return new CalculateBeforeAdvice();
    }

    @Bean
    public ProxyFactoryBean calculateProxy() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setInterceptorNames("calculateBeforeAdvice","loggerInterceptor");
        proxyFactoryBean.setTarget(calculate());
        return proxyFactoryBean;
    }

}
