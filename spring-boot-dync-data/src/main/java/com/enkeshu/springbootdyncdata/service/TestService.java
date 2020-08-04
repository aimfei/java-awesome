package com.enkeshu.springbootdyncdata.service;

import com.enkeshu.springbootdyncdata.annotation.Master;
import com.enkeshu.springbootdyncdata.annotation.Slave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TestService {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Master
    public Object getObj() {
        return jdbcTemplate.queryForMap("select * from t_area where code=340000");
    }

    @Slave
    public Object getObj1() {
        return jdbcTemplate.queryForMap("select * from t_area where code=410000");
    }
}
