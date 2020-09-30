package com.test;

import com.test.Bean.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EurakaClienApplication.class)
public class redisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

   /* @Autowired
    private Category category;*/

    @Test
    public void  test(){
       //redisTemplate.opsForValue().set("key3",category,10, TimeUnit.SECONDS);
       //redisTemplate.opsForSet().add("city","guangzhou","city1","shenzhen","city","chongqing");
       //redisTemplate.opsForSet().add("city","guangzhou","city2","shenzhen","city","chongqing");

    }

    @Test
    public void test2(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.
    }
}
