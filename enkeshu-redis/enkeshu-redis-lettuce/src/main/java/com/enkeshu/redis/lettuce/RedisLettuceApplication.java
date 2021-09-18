package com.enkeshu.redis.lettuce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

import java.nio.charset.StandardCharsets;

/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/4/30
 **/
public class RedisLettuceApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(RedisConfig.class);
        applicationContext.refresh();

        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("username", "zhangsan");
        Object o = redisTemplate.opsForValue().get("username");
        System.out.println(o);
        redisTemplate.execute((RedisCallback) redisConnection -> redisConnection.set("username1".getBytes(StandardCharsets.UTF_8), "lisi".getBytes(StandardCharsets.UTF_8)));
        ///String result = " local config ={a=1,name=\"good\"}for key, value in pairs(config) do print(key,value) end return config";
        //String result="do local config ={a=1,name=\"good\"} return config end ";

        //String result=" local function  get_data() local config = {a=1,name= 2 } return config end return get_data() ";
        String result="local config = {a=1,name= 2 } return config";
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                String load = redisConnection.scriptLoad(result.getBytes(StandardCharsets.UTF_8));
                System.out.println(load);
                //645b62b3d1d8c3420520cf44ea81019a4c142348
                Object o1 = redisConnection.evalSha(load, ReturnType.VALUE, 1, "1".getBytes(StandardCharsets.UTF_8));
                System.out.println(o1);
                return null;
            }
        });
      /*  Object execute = redisTemplate.execute((RedisCallback<String>) redisConnection -> {
            byte[] bytes = redisConnection.get("username1".getBytes(StandardCharsets.UTF_8));
            return new String(bytes, StandardCharsets.UTF_8);

        });
        System.out.println(execute);*/


    }
}
