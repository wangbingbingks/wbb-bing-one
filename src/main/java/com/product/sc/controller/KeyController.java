package com.product.sc.controller;

import com.corsface.base.proto.ReturnData;
import com.corsface.base.web.AbstractApiController;
import com.product.sc.dao.MKeyDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by wbb on 2020/8/13.
 */

@RestController
@RequestMapping("/key")
public class KeyController extends AbstractApiController {

    @Autowired
    private MKeyDetailsDao mKeyDetailsDao;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ReturnData add(HttpServletRequest request) {
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);

        //得到数据库中的所有已生成的激活码
        List<String> list = mKeyDetailsDao.getAllMKeyDetails();

        //生成随机6位数激活码
        Set<String> activationCode = new HashSet<String>();
        for (int i = 1; i <= 100; i++) {
            String sources = "0123456789"; // 也可以加上一些字母
            Random rand = new Random();
            StringBuffer flag = null;
            do {
                flag = new StringBuffer();
                for (int j = 0; j < 6; j++) {
                    flag.append(sources.charAt(rand.nextInt(10)) + "");
                }
            } while (list.contains(flag.toString()) || activationCode.contains(flag.toString()));

            activationCode.add(flag.toString());
            System.out.println("flag" + i + " = " + flag);
        }
        Date now = new Date();
        int addCount = mKeyDetailsDao.saveMKeyDetails(activationCode, now);
        returnData.setResultForSucces("操作成功，共生成了" + addCount + "个激活码", "");

        return returnData;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("username", "wangbing");
        modelAndView.addObject("password", "123456");
        return modelAndView;
    }
}
