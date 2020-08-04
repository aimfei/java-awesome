package com.enkeshu.springbootdyncdata.config;

import com.enkeshu.springbootdyncdata.annotation.DbConst;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


@Configurable
public class DynamicDataSource extends AbstractRoutingDataSource {


    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    @Override
    protected Object determineCurrentLookupKey() {
        return contextHolder.get();
    }


    public static void master() {
        contextHolder.set(DbConst.MASTER_DATASOURCE);
    }


    public static void slave() {
        contextHolder.set(DbConst.SLAVE_DATASOURCE);
    }

    public static void setDatabase(String dbSource) {
        if (dbSource == null || dbSource.equals(DbConst.MASTER_DATASOURCE)) {
            contextHolder.set(DbConst.MASTER_DATASOURCE);
        } else {
            contextHolder.set(DbConst.SLAVE_DATASOURCE);
        }

    }

    public static String getType() {
        return contextHolder.get();
    }

    public static void cleanAll() {
        contextHolder.remove();
    }


}
