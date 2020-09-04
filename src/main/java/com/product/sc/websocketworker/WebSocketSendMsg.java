package com.product.sc.websocketworker;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.listener.ConnectListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class WebSocketSendMsg {
    protected final Logger logger = LoggerFactory.getLogger(WebSocketSendMsg.class);

    public final static String WS_NS_FTMSG = "/poimsg";

    private final int port = 8193;

    private SocketIOServer socketIOServer;

    private ExecutorService singleExecutor;


    @PostConstruct
    private void initWebSocketServer(){

        Configuration configuration = new Configuration();
        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);

        configuration.setSocketConfig(socketConfig);
        configuration.setPort(port);

        socketIOServer = new SocketIOServer(configuration);
        logger.info("-->WsAdminWork, initWsServer, port:{}", port);

        SocketIONamespace socketIONamespace = socketIOServer.addNamespace(WS_NS_FTMSG);
        socketIONamespace.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                logger.debug("--> client connted.");
            }
        });

        singleExecutor = Executors.newSingleThreadExecutor();

        socketIOServer.start();
        logger.info("-->WsWorker, initWsServer, server start.");

    }

    public void wsSendMsg(final String msg){
        try {
            logger.debug("--> wsSendFtMsg...");
            singleExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    SocketIONamespace namespace = socketIOServer.getNamespace(WS_NS_FTMSG);
                    namespace.getBroadcastOperations().sendEvent(WS_NS_FTMSG, msg);

                    logger.debug("--> send to websocket. msg:{}", msg);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            logger.error("--> error, wsSendFtMsg, error:{}", e.getMessage());
        }
    }

}
