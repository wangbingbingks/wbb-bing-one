package com.product.sc.rabbitmq;

import com.product.sc.entity.CfPoi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by wbb on 2020/8/25.
 * Description:No
 */

@Component
public class SendQueuedMsg {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("rabbitTemplate_poi")
    private RabbitTemplate rabbitTemplate_poi;


    public boolean sendPoi(CfPoi cfPoi){
        boolean rst = false;
        try {
            rabbitTemplate_poi.convertAndSend(cfPoi);
            rst = true;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("--> error, sendNotify", e);
        }
        return rst;
    }
}
