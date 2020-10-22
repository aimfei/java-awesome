package com.ekneshu.spring.config.component;

import com.ekneshu.spring.bean.Account;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanBizProcessor implements BeanPostProcessor{//, InitializingBean {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Account){
            System.out.println("account 开始执行");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Account){
            System.out.println("account 已执行完成");
        }
        return bean;
    }

   // @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializingBean 开始执行");
    }
}
