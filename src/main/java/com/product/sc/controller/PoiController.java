package com.product.sc.controller;

import com.corsface.base.proto.ReturnData;
import com.corsface.base.web.AbstractApiController;
import com.product.sc.entity.CfPoi;
import com.product.sc.rabbitmq.SendQueuedMsg;
import com.product.sc.redis.PoiRedisDao;
import com.product.sc.service.PoiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by wbb on 2020/8/13.
 */

@RestController
@RequestMapping("poi")
public class PoiController extends AbstractApiController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PoiRedisDao poiRedisDao;

    @Autowired
    private PoiService service;

    @Autowired
    private SendQueuedMsg sendQueuedMsg;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ReturnData add(HttpServletRequest request) {
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);
        Date now = new Date();
        CfPoi cfPoi = new CfPoi();
        cfPoi.setName("汪兵兵");
        cfPoi.setPersonId("45896-fd-s56f56s-das84-4846ds5");
        cfPoi.setGender(1);
        cfPoi.setGmtCreate(now);
        try {
            if (poiRedisDao.save(cfPoi)) {
                returnData.setResultForSucces("");
            } else {
                returnData.setResultForCommonFail("添加失败", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setResultForCommonFail("redis存储发生异常", "");
        }

        return returnData;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ReturnData get(HttpServletRequest request) {
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);

        String personId = request.getParameter("personId");
        try {
            CfPoi cfPoi = poiRedisDao.get(personId);
            returnData.setResultForSucces(cfPoi);
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setResultForCommonFail("redis发生异常", "");
        }

        return returnData;
    }

    @RequestMapping(value = "/ceTran", method = RequestMethod.GET)
    public ReturnData ceTran(HttpServletRequest request) {
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);
        try {
            service.ceTran();
            returnData.setResultForSucces(true);
        } catch (Exception e) {
            e.printStackTrace();
            returnData.setResultForCommonFail(e.getMessage(), false);
        }

        return returnData;
    }

    @GetMapping("sendMsg")
    public ReturnData sendMsg(HttpServletRequest request){
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);
        CfPoi cfPoi = new CfPoi();
        cfPoi.setName("汪兵兵：发来密文");
        try {
            sendQueuedMsg.sendPoi(cfPoi);
            returnData.setResultForSucces("发送成功", true);
        }catch (Exception e){
            e.printStackTrace();
            returnData.setResultForCommonFail("发送错误", false);
        }

        return returnData;
    }


}
