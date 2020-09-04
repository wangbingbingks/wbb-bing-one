package com.product.sc.redis;

import com.product.sc.entity.CfPoi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * Created by wbb on 2020/8/13.
 */

@Configuration
public class RedisSerializerConfig {

    @Bean(name = "cfPoiSerializer")
    public Jackson2JsonRedisSerializer<CfPoi> cfPoi() {
        Jackson2JsonRedisSerializer<CfPoi> serializer = new Jackson2JsonRedisSerializer<>(CfPoi.class);
        return serializer;
    }
}
