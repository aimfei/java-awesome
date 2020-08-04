package com.enkeshu.springbootdyncdata.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Master {
    String value() default DbConst.MASTER_DATASOURCE;
}
