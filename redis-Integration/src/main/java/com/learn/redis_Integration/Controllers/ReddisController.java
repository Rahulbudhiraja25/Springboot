package com.learn.redis_Integration.Controllers;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class ReddisController {
    public static void main(String[] args) {
        try(Jedis jedis = new Jedis("localhost", 6379)) {
            jedis.set("user:6","Hello from jedis");
            jedis.ping();
//            jedis.set("framework", "Spring Boot");
            Set<String> keys = jedis.keys("*");
            for (String key : keys) {
                System.out.println(key + ": " + jedis.get(key));
            }
        }
        catch(Exception e){
            System.out.println("Exception in connecting to reddis: " + e);
        }
    }
}
