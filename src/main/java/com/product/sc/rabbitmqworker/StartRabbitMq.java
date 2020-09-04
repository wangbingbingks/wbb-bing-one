package com.product.sc.rabbitmqworker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StartRabbitMq {
    protected final Logger logger = LoggerFactory.getLogger(StartRabbitMq.class);


    @Autowired
    @Qualifier("listener_container_poi")
    private AbstractMessageListenerContainer listenerContainer_poi;

    @PostConstruct
    private void initRabbit(){

        try {
            logger.info("-->start rabbitmq listeners...");
            listenerContainer_poi.start();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("-->error, start RabbitListeners, error:{}", e.getMessage());
        }

    }

}
