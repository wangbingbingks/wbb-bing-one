package com.product.sc.controller;

import com.corsface.base.web.AbstractApiController;
import com.dtflys.forest.config.ForestConfiguration;
import com.product.sc.forestreq.MyClient;
import com.product.sc.forestreq.MyClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wbb on 2020/8/13.
 */

@RestController
public class TestController extends AbstractApiController {

    protected final Logger logger = LoggerFactory.getLogger(TestController.class);

    private int count = 0;

    @Autowired
    private MyClientService myClientService;

    @RequestMapping(value = "/demoget", method = RequestMethod.GET)
    public String demoGet(HttpServletRequest request) {
        MyClient myClient = ForestConfiguration.configuration().createInstance(MyClient.class);

        String name = request.getParameter("name");
        if (null != name) {
            System.out.println("name = " + name);
        }
        logger.info("输入的名字为：name:{}", name);
        String infoMsg = myClientService.getMyClient().simpleRequest("1", "1");
        System.out.println("infoMsg = " + infoMsg);
        /*String info = myClient.simpleRequest("1", "1");
        System.out.println("info = " + info);*/


        return "get 是的 aa";
    }


    @RequestMapping(value = "/demopost", method = RequestMethod.POST)
    public String demoPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (null != name) {
            System.out.println("name = " + name);
        }

        return "post 是的 aa";
    }

    @GetMapping("/showResult")
    public Integer showResult(){
        return count;
    }

    @GetMapping("/addCount")
    public void addCount(HttpServletRequest request) {
        count++;
    }
}
