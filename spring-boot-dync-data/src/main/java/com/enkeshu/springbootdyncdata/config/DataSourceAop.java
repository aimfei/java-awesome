package com.enkeshu.springbootdyncdata.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DataSourceAop {
    @Before("(@annotation(com.enkeshu.springbootdyncdata.annotation.Master)&& !@annotation(com.enkeshu.springbootdyncdata.annotation.Slave))")
    public void setWriteDataSourceType() {
        DynamicDataSource.master();
        log.info("dataSource切换到：master");
    }

    @Before("(@annotation(com.enkeshu.springbootdyncdata.annotation.Slave) && !@annotation(com.enkeshu.springbootdyncdata.annotation.Master))")
    public void setReadDataSourceType() {
        DynamicDataSource.slave();
        log.info("dataSource切换到：slave");
    }
}
