package com.product.sc.forestreq;

import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.ssl.SSLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class MyClientService {
    protected final Logger logger = LoggerFactory.getLogger(MyClientService.class);

    private MyClient myClient;


    public MyClientService(){
        logger.info("-->:init ForestConfiguration start");


        ForestConfiguration configuration = ForestConfiguration.configuration();

        configuration.setBackendName("okhttp3");//目前 Forest 支持okhttp3和httpclient两种后端 HTTP API
        // 连接池最大连接数，默认值为500
        configuration.setMaxConnections(123);
        // 每个路由的最大连接数，默认值为500
        configuration.setMaxRouteConnections(222);
        // 请求超时时间，单位为毫秒, 默认值为3000
        configuration.setTimeout(3000);
        // 连接超时时间，单位为毫秒, 默认值为2000
        configuration.setConnectTimeout(2000);
        // 请求失败后重试次数，默认为0次不重试
        configuration.setRetryCount(3);
        // 单向验证的HTTPS的默认SSL协议，默认为SSLv3
        configuration.setSslProtocol(SSLUtils.SSLv3);
        // 打开或关闭日志，默认为true
        configuration.setLogEnabled(true);

        configuration.setVariableValue("username", "wbb");
        configuration.setVariableValue("password", "123456");

        myClient = configuration.createInstance(MyClient.class);

        logger.info("-->:init ForestConfiguration end");

    }


    public MyClient getMyClient() {
        return myClient;
    }

    public void setMyClient(MyClient myClient) {
        this.myClient = myClient;
    }

}
