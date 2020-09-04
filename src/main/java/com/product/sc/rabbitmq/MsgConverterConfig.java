package com.product.sc.rabbitmq;

import com.product.sc.entity.CfPoi;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wbb on 2020/8/25.
 */

@Configuration
public class MsgConverterConfig {

    @Bean(name = "cfPoiMsgConverter")
    public MessageConverter poi() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        DefaultClassMapper cm = new DefaultClassMapper();
        cm.setTrustedPackages("*");
        cm.setDefaultType(CfPoi.class);
        converter.setClassMapper(cm);

        return converter;
    }
}
