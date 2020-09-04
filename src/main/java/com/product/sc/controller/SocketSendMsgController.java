package com.product.sc.controller;

import com.corsface.base.proto.ReturnData;
import com.corsface.base.web.AbstractApiController;
import com.product.sc.websocketworker.WebSocketSendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SocketSendMsgController extends AbstractApiController {


    @Autowired
    private WebSocketSendMsg webSocketSendMsg;

    @GetMapping("wsSendMsg")
    public ReturnData wsSendMsg(HttpServletRequest request){
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);

        String msg = "河南省郑州市发来一条密报";
        webSocketSendMsg.wsSendMsg(msg);
        logger.info("-->:wsSendMsg:{}", msg);
        returnData.setResultForSucces("发送成功！");
        return returnData;
    }

}
