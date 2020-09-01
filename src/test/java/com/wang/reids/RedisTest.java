package com.wang.reids;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTest {

    private Jedis jedis;

    @Test
    public void test(){
        jedis.set("hello","world");
    }

    @Test
    public void test2(){
        jedis.lpush("name","xioaming","lili","wangwu","tianqi");
    }

    @Test
    public void test3(){
        JedisPool pool = new JedisPool("192.168.6.102", 6379);

        Jedis jedis = pool.getResource();

        jedis.hset("user","name","lisi");

        jedis.close();
    }


    @Before
    public void init(){

        jedis = new Jedis("192.168.6.102",6379);

    }

    @After
    public void close(){
        jedis.close();
    }
}
