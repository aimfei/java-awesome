package com.enkeshu;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import redis.clients.jedis.Jedis;

public class StrTest {

    private static Jedis JEDIS_INITANCE;

    @BeforeAll
    public static void init() {
        JEDIS_INITANCE = new Jedis("localhost", 6379);
    }

    @AfterAll
    public static void destroy() {
        JEDIS_INITANCE.close();
    }


    @DisplayName("set测试")
    @ParameterizedTest
    @ValueSource(strings = "张三")
    public void testSetSimple(String string) {
        JEDIS_INITANCE.set("username",string);
        String username = JEDIS_INITANCE.get("username");
        Assertions.assertTrue("张三".equals(username));

    }
}
