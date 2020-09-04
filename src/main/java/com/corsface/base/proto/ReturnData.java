package com.corsface.base.proto;

import java.io.Serializable;
/**
 * Created by wbb on 2020/8/13.
 */
public class ReturnData implements Serializable {

    private int status;
    private String message;
    private Object result;

    public ReturnData() {
    }

    public ReturnData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ReturnData(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    //成功
    public void setResultForSucces(Object result) {
        this.result = result;
        this.status = ReturnDataConstans.STATUS_OK;
        this.message = ReturnDataConstans.MESSAGE_SUCCESS;
    }

    //成功
    public void setResultForSucces(String message, Object result) {
        this.result = result;
        this.status = ReturnDataConstans.STATUS_OK;
        this.message = message;
    }

    //失败
    public void setResultForCommonFail(String message, Object result) {
        this.result = result;
        this.status = ReturnDataConstans.STATUS_ERR_COMMON_FAIL;
        this.message = message;
    }

    //参数无效
    public void setResultForInvalidPara(String message, Object result) {
        this.result = result;
        this.status = ReturnDataConstans.STATUS_ERR_PARA_INVALID;
        this.message = message;
    }

    //自定义返回值
    public void set(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
