package com.bryan;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

import java.util.Date;

public class lettuceTest {

    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://192.168.56.101");
        System.out.println(new Date());
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        System.out.println(new Date());
        System.out.println("Connected to Redis");
        connection.sync().set("key", "tom");
       String val= connection.sync().get("key");
        System.out.println(val);
        connection.close();
        redisClient.shutdown();
    }
}
