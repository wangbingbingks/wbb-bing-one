package com.product.sc.rabbitmqworker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqDataIniter implements SmartLifecycle, Runnable {
    protected final Logger logger = LoggerFactory.getLogger(RabbitMqDataIniter.class);

    @Override
    public boolean isAutoStartup() {
        return false;
    }

    @Override
    public void stop(Runnable callback) {
        logger.info("-->RedisIniter, stop(callback)");
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public void run() {

    }
}
