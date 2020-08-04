package com.enkeshu.springbootdyncdata.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Slave {
    String value() default DbConst.SLAVE_DATASOURCE;
}
