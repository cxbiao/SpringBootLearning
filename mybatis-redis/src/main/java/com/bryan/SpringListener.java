package com.bryan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:jdbc.properties")
public class SpringListener implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger= LoggerFactory.getLogger(SpringListener.class);

    @Value("${url}")
    private String url;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //redis spring启动时开启连接，要不然第一次很慢
        logger.info("spring启动完成1");
       // redisTemplate.opsForValue().get("test");

    }
}
