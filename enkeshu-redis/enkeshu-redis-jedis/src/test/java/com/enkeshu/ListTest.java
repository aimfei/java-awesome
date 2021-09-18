package com.enkeshu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class ListTest {


    private static Jedis JEDIS_INITANCE;

    @BeforeAll
    public static void init() {
        JEDIS_INITANCE = new Jedis("localhost", 6379);
    }

    @AfterAll
    public static void destroy() {
        JEDIS_INITANCE.close();
    }

    @Test
    public void testSmembers() {


        Set<String> smembers1 = JEDIS_INITANCE.smembers("smembers:key:1");
        Set<String> smembers2 = JEDIS_INITANCE.smembers("smembers:key:2");
        System.out.println(smembers1);
        System.out.println(smembers2);
    }

    @Test
    public void testSdiff() {
        String useridsKey1 = "smembers:key:1";
        String useridsKey2 = "smembers:key:2";
        Set<String> sdiff = JEDIS_INITANCE.sdiff(useridsKey1, useridsKey2);
        System.out.println(sdiff);
    }

    @Test
    public void testInner() {
        String useridsKey1 = "smembers:key:1";
        String useridsKey2 = "smembers:key:2";
        Set<String> sinter = JEDIS_INITANCE.sinter(useridsKey1, useridsKey2);
        System.out.println(sinter);
    }
}
