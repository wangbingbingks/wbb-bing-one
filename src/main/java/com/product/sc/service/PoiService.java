package com.product.sc.service;

import com.product.sc.dao.PoiDao;
import com.product.sc.dao.SimpleDao;
import com.product.sc.entity.CfPoigroup;
import com.product.sc.entity.CfPoigroupMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by wbb on 2020/8/13.
 */

@Service
public class PoiService {

    @Autowired
    private SimpleDao simpleDao;

    @Autowired
    private PoiDao dao;

    @Transactional(rollbackFor = Exception.class)
    public void ceTran() {
        Date now = new Date();
        CfPoigroup poigroup = new CfPoigroup();
        poigroup.setName("测试分组6");
        poigroup.setMemo("测试分组6");
        poigroup.setIsDefault(0);
        poigroup.setGmtCreate(now);
        poigroup.setGmtModified(now);
        dao.save(poigroup);

        CfPoigroupMap poigroupMap = new CfPoigroupMap();
        poigroupMap.setPoiId(1l);
        poigroupMap.setGroupId(1l);
        poigroupMap.setGmtCreate(now);
        poigroupMap.setGmtModified(now);
        dao.save(poigroupMap);

        String s = "s";
        Integer.parseInt(s);

    }
}
