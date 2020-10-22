package com.ekneshu.spring.bean;

import org.springframework.beans.factory.FactoryBean;

public class PersonalFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Personal personal = new Personal();
        personal.setImageUrl("http://www.baidu.com");
        return personal;
    }

    @Override
    public Class<?> getObjectType() {
        return Personal.class;
    }
}
