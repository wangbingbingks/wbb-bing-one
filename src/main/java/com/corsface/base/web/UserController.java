package com.corsface.base.web;

import com.corsface.base.dao.BeUserDao;
import com.corsface.base.entity.BeUser;
import com.corsface.base.proto.ReturnData;
import com.corsface.base.proto.ReturnDataConstans;
import com.corsface.base.service.BeUserService;
import com.corsface.base.util.Utils;
import com.product.sc.proto.CfPageData;
import com.product.sc.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
/**
 * @version: V1.0
 * @author: wbb
 * @className: user
 * @packageName: user
 * @description: 这是用户类
 * @data: 2020年8月13日15:44:19
 */

@RestController
public class UserController extends AbstractApiController {

    @Autowired
    private BeUserService beUserService;

    @Autowired
    private BeUserDao beUserDao;

    @RequestMapping(value = "/admin/user/list", method = RequestMethod.GET)
    public ReturnData list(HttpServletRequest request) {
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);

        if(!checkListParams(request)){
            return returnData;
        }

        //必要参数
        int pageSize = StringUtils.getIntParameter(request, "pageSize");
        int currentPage = StringUtils.getIntParameter(request, "currentPage");

        //选填参数
        String loginName = Utils.clean(request.getParameter("loginName"));
        String name = Utils.clean(request.getParameter("name"));

        CfPageData pageData = beUserService.getAllBeUsers(pageSize, currentPage, loginName, name);
        returnData.setResultForSucces(pageData);
        return returnData;
    }
    private boolean checkListParams(HttpServletRequest request){
        ReturnData returnData = getReturnDataFromReqAttr(request);

        String pageSize = StringUtils.getCleangParameter(request, "pageSize");
        String currentPage = StringUtils.getCleangParameter(request, "currentPage");
        if(!StringUtils.isInteger(pageSize)){
            returnData.setResultForInvalidPara("无效的 pageSize", "");
            return false;
        }
        if(!StringUtils.isInteger(currentPage)){
            returnData.setResultForInvalidPara("无效的 currentPage", "");
            return false;
        }
        return true;
    }

    /**
     * @author:  wbb
     * @methodsName: add
     * @description: 添加一个用户
     * @param:  loginName,name,password,serviceFlag
     * @return: ReturnData
     * @throws:
     */
    @RequestMapping(value = "/admin/user/add", method = RequestMethod.POST)
    public ReturnData add(HttpServletRequest request) {
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);

        if(!checkAddParams(request)){
            return returnData;
        }

        String loginName = Utils.clean(request.getParameter("loginName"));
        String name = Utils.clean(request.getParameter("name"));
        String password = Utils.clean(request.getParameter("password"));
        int serviceFlag = Integer.parseInt(request.getParameter("serviceFlag"));//用户状态

        Date now = new Date();
        BeUser beUser = beUserService.getUserByLoginName(loginName);
        if (beUser == null) {
            beUser = new BeUser();
            String salt = System.currentTimeMillis() + "";
            String newPassword = new Md5Hash(password, salt).toHex().toLowerCase();

            beUser.setName(name);
            beUser.setPassword(newPassword);
            beUser.setLoginName(loginName);
            beUser.setServiceFlag(serviceFlag);
            beUser.setGmtCreate(now);
            beUser.setGmtModified(now);
            beUser.setSalt(salt);

            beUserDao.save(beUser);

        }else{
            //用户已经存在
            returnData.set(ReturnDataConstans.STATUS_ERR_BIZ_EXISTRECORD, ReturnDataConstans.MESSAGE_ERR_BIZ_EXISTRECORD, "");
        }

        return returnData;
    }
    private boolean checkAddParams(HttpServletRequest request){
        ReturnData returnData = getReturnDataFromReqAttr(request);

        /**
         * 必须参数
         */
        String loginName = request.getParameter("loginName");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String serviceFlag = request.getParameter("serviceFlag");

        if (Utils.isBlank(loginName)) {
            returnData.setResultForInvalidPara("无效的 登录名", "invalid loginName");
            return false;
        }
        if (Utils.isBlank(name)) {
            returnData.setResultForInvalidPara("无效的 名称", "invalid name");
            return false;
        }
        if (Utils.isBlank(password)) {
            returnData.setResultForInvalidPara("无效的 密码", "invalid password");
            return false;
        }
        if (!Utils.isInteger(serviceFlag)) {
            returnData.setResultForInvalidPara("无效的 状态", "invalid serviceFlag");
            return false;
        }
        return true;
    }

    /**
     * @author:  wbb
     * @methodsName: del
     * @description: 删除一个用户
     * @param:  id
     * @return: ReturnData
     * @throws:
     */
    @RequestMapping(value = "/admin/user/del", method = RequestMethod.POST)
    public ReturnData del(HttpServletRequest request) {
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);

        if (!checkDeleteParams(request)) {
            return returnData;
        }

        Subject subject = SecurityUtils.getSubject();
        String current_loginName = (String) subject.getPrincipal();

        int id = Integer.parseInt(request.getParameter("id"));

        BeUser beUser = beUserService.getUserById(id);
        if(beUser != null){
            if(beUser.getLoginName().equals(current_loginName)){
                //自己不能删除自己
                returnData.setResultForCommonFail("不能删除自己", "");
            }else{
                beUserService.deleteAll(beUser.getId());
            }
        }else{
            returnData.set(ReturnDataConstans.STATUS_ERR_BIZ_NORECORD, ReturnDataConstans.MESSAGE_ERR_BIZ_NORECORD, "");
        }
        return returnData;
    }

    private boolean checkDeleteParams(HttpServletRequest request){
        ReturnData returnData = getReturnDataFromReqAttr(request);
        String id = request.getParameter("id");
        if(!Utils.isInteger(id)){
            returnData.setResultForInvalidPara("无效的用户ID", "invalid id");
            return false;
        }
        return true;
    }

    /**
     * @author:  wbb
     * @methodsName: modify
     * @description: 修改一个用户
     * @param:  id
     * @return: ReturnData
     * @throws:
     */
    @RequestMapping(value = "/admin/user/modify", method = RequestMethod.POST)
    public ReturnData modify(HttpServletRequest request) {
        prepare(request);
        ReturnData returnData = getReturnDataFromReqAttr(request);

        if(!checkModifyPara(request)){
            return returnData;
        }

        int id =Integer.parseInt(request.getParameter("id"));
        String name =Utils.clean(request.getParameter("name"));
        String password =Utils.clean(request.getParameter("password"));
        int serviceFlag =Integer.parseInt(request.getParameter("serviceFlag"));

        Date now = new Date();

        BeUser beUser = beUserService.getUserById(id);
        if(beUser != null){
            if(!Utils.isBlank(password)){
                String salt = System.currentTimeMillis() + "";
                String newPassword = new Md5Hash(password, salt).toHex().toLowerCase();
                beUser.setSalt(salt);
                beUser.setPassword(newPassword);
            }

            beUser.setName(name);
            beUser.setServiceFlag(serviceFlag);
            beUser.setGmtModified(now);
            beUserDao.save(beUser);
        }else{
            returnData.set(ReturnDataConstans.STATUS_ERR_BIZ_NORECORD, ReturnDataConstans.MESSAGE_ERR_BIZ_NORECORD, "");
        }

        return returnData;
    }

    private boolean checkModifyPara(HttpServletRequest request){
        ReturnData returnData = getReturnDataFromReqAttr(request);

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String serviceFlag = request.getParameter("serviceFlag");

        if (!Utils.isInteger(id)) {
            returnData.setResultForInvalidPara("无效的 用户ID", "invalid id");
            return false;
        }
        if (Utils.isBlank(name)) {
            returnData.setResultForInvalidPara("无效的 名称", "invalid name");
            return false;
        }
        if (!Utils.isInteger(serviceFlag)) {
            returnData.setResultForInvalidPara("无效的 状态", "invalid serviceFlag");
            return false;
        }

        return true;
    }
}
