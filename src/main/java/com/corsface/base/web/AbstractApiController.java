package com.corsface.base.web;

import com.corsface.base.proto.ReturnData;
import com.corsface.base.proto.ReturnDataConstans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by wbb on 2020/8/13.
 */
public abstract class AbstractApiController {
    public final static String REQ_ATTRNAME_RETURNDATA = "returnData";
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected void prepare(HttpServletRequest request) {
        //设置returnData
        ReturnData returnData = new ReturnData(ReturnDataConstans.STATUS_OK, "init", null);
        request.setAttribute(REQ_ATTRNAME_RETURNDATA, returnData);
    }

    protected ReturnData getReturnDataFromReqAttr(HttpServletRequest request) {
        return (ReturnData) request.getAttribute(REQ_ATTRNAME_RETURNDATA);
    }
}
