package com.product.sc.forestreq;

import com.dtflys.forest.annotation.DataParam;
import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Request;

public interface MyClient {


    /**
     * 默认GET请求
     * @param pageSize
     * @return
     */
    @Request(url = "http://192.168.1.182:8090/cfAdmin/facetrackHistory/mFaceTrackHistoryDetail")
    String simpleRequest(@DataParam("pageSize") String pageSize, @DataParam("pageNo") String pageNo);


    /**
     * POST请求
     * @param
     * @return
     */
    @Request(url = "", type = "POST")
    String simplePost();


    /**
     * 设置多个固定的请求头
     * @param
     * @return
     */
    @Request(url = "", headers = {"Accept-Charset: utf-8", "Content-Type: text/plain"})
    String multipleHeaders();

    /**
     * 设置多个变化的请求头，使用数据绑定
     * @param
     * @return
     */
    @Request(url = "", headers = {"Accept-Charset: ${encoding}", "Content-Type: text/plain"})
    String bindingHeader(@DataVariable("encoding") String encoding);


}
