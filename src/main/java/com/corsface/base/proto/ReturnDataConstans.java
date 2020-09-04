package com.corsface.base.proto;
/**
 * Created by wbb on 2020/8/13.
 */
public class ReturnDataConstans {
    public final static int STATUS_OK = 0; // API返回状态正常

    public final static int STATUS_ERR_COMMON_FAIL = 1; //业务操作失败（通用，不做细区分)
    public final static int STATUS_ERR_LOGINFAIL = 2; //登陆失败(用户名/密码错误)
    public final static int STATUS_ERR_CAPTCHA_CODE = 3; //验证码错误
    public final static int STATUS_ERR_USER_STATUS = 4; // 账号状态异常

    public final static int STATUS_ERR_SYSTEMERROR = 500; // 服务器内部发生错误
    public final static int STATUS_ERR_FILE_TYPE_ERROR = 501; // 文件类型错误

    public final static int STATUS_ERR_UN_AUTHC = 101; //用户未登陆
    public final static int STATUS_ERR_UN_AUTHZ = 102; //用户无权限执行该操作

    public final static int STATUS_ERR_PARA_MISS = 201; // 业务参数缺少
    public final static int STATUS_ERR_PARA_INVALID = 202; // 业务参数无效(格式或内容)或不存在

    public final static int STATUS_ERR_BIZ_NORECORD = 301; // 没有记录（业务）
    public final static int STATUS_ERR_BIZ_EXISTRECORD = 302; // 存在记录（业务）

    public final static int STATUS_ERR_BIZ_SAVE_FILE_ERROR = 303; // 文件保存失败


    public final static String MESSAGE_SUCCESS = "操作成功";
    public final static String MESSAGE_ERR_LOGINFAIL = "用户名/密码错误";
    public final static String MESSAGE_ERR_CAPTCHA_CODE = "验证码错误";
    public final static String MESSAGE_ERR_USER_STATUS = "账号状态异常";

    public final static String MESSAGE_ERR_UN_AUTHC = "未登陆,请退出,重新登陆";
    public final static String MESSAGE_ERR_UN_AUTHZ = "无权限执行该操作";

    public final static String MESSAGE_ERR_BIZ_NORECORD = "没有记录";
    public final static String MESSAGE_ERR_BIZ_EXISTRECORD = "已经存在记录";

    public final static String MESSAGE_ERR_FILE_TYPE_ERROR = "文件类型错误，请上传正确的图片";

    public final static String MESSAGE_ERR_SAVE_FILE_ERROR = "文件保存失败";
}
