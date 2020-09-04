package com.product.sc.init;

import com.product.sc.proto.invoice.InvoiceKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InvoiceKeyInit {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void init(){
        InvoiceKey.masterKey ="1re59FU9hRzEm279";
        InvoiceKey.workerKey ="1re59FU9hRzEm279";
    }
}
