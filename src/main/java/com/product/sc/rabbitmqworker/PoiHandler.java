package com.product.sc.rabbitmqworker;

import com.product.sc.entity.CfPoi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("poiHandler")
public class PoiHandler {
    protected final Logger logger = LoggerFactory.getLogger(PoiHandler.class);

    public void handle(CfPoi cfPoi){
        System.out.println("--> poiHandler");
        try {
            logger.debug("--> handle cfPoi, poi name:{}", cfPoi.getName());
            processCfPoiMsg(cfPoi);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("--> error, PoiHandler, handle.", e);
        }
    }

    private void processCfPoiMsg(CfPoi cfPoi){
        logger.debug("--> processCfPoiMsg.");
        System.out.println("cfPoi.name = " + cfPoi.getName());
    }
}
