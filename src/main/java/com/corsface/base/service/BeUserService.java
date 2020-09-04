package com.corsface.base.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.corsface.base.dao.BeRoleDao;
import com.corsface.base.dao.BeUserDao;
import com.corsface.base.dao.BeUserRoleDao;
import com.corsface.base.entity.BeRole;
import com.corsface.base.entity.BeUser;
import com.product.sc.proto.CfPage;
import com.product.sc.proto.CfPageData;
import com.product.sc.proto.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbb on 2020/8/13.
 */
@Service
public class BeUserService {

    @Autowired
    private BeUserDao beUserDao;

    @Autowired
    private BeUserRoleDao beUserRoleDao;

    @Autowired
    private BeRoleService beRoleService;


    public BeUser getUserByLoginName(String loginName) {
        return beUserDao.getUserByLoginName(loginName);
    }

    public BeUser getUserById(int id) {
        return beUserDao.getUserById(id);
    }

    public boolean deleteAll(Long userId) {
        return beUserDao.deleteAll(userId);
    }

    public CfPageData getAllBeUsers(int pageSize, int currentPage, String loginName, String name) {
        CfPageData pageData = new CfPageData();
        PageBean pageBean = new PageBean(pageSize, currentPage);
        //起始行数
        int startIndex = pageBean.getStartIndex();

        long total = beUserDao.getAllBeUsersTotal(loginName, name);
        pageData.setPage(new CfPage(pageSize, startIndex, (int) total));
        List<BeUser> list = beUserDao.getAllBeUsersData(pageSize, startIndex, loginName, name);
        JSONArray rst = new JSONArray();

        for (BeUser user : list) {
            String token = user.getToken();
            boolean isInitialization = beUserRoleDao.getIsInitialization(token);
            user.setSalt("");
            user.setToken("");
            user.setPassword("");
            JSONObject userJSON = (JSONObject) JSONObject.toJSON(user);
            if(isInitialization){
                userJSON.put("roles", beRoleService.getAllRole());
            }else{
                List<BeRole> roleList = beUserRoleDao.getRoleByUserId(user.getId());
                userJSON.put("roles", roleList);
            }
            userJSON.put("isInitialization", isInitialization);
            rst.add(userJSON);
        }
        pageData.setList(rst);
        return pageData;
    }
}
