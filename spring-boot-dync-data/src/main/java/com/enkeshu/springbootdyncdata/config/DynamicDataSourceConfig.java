package com.enkeshu.springbootdyncdata.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.enkeshu.springbootdyncdata.annotation.DbConst;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DynamicDataSourceConfig implements EnvironmentAware {
    @Value("${spring.datasource.master.url}")
    private String masterJdbcurl;
    @Value("${spring.datasource.slave.url}")
    private String slaveJdbcurl;


    public DynamicDataSourceConfig() {
        System.out.println("####################  DataBaseConfiguration");
    }

    @Override
    public void setEnvironment(Environment env) {
        // this.propertyResolverMaster = new RelaxedPropertyResolver(env, "datasource.business.");
        //this.propertyResolverSlave = new RelaxedPropertyResolver(env, "datasource.business_slave.");
    }

    public DataSource master() {
        System.out.println("注入 Master druid！！！");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(masterJdbcurl);
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUsername("root");
        datasource.setPassword("123456");
        return datasource;
    }

    public DataSource slave() {
        System.out.println("Slave druid！！！");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(slaveJdbcurl);
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUsername("root");
        datasource.setPassword("123456");
        return datasource;
    }

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DataSource master = master();
        DataSource slave = slave();
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DbConst.MASTER_DATASOURCE, master);
        targetDataSources.put(DbConst.SLAVE_DATASOURCE, slave);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(master);
        return dataSource;
    }


}
