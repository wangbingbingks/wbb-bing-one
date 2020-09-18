package com.product.sc.dao;

import com.corsface.base.dao.AbstractBaseDao;
import com.product.sc.entity.CfMGateStrategyConfig;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CfMGateConfigDao extends AbstractBaseDao {

    @Transactional
    public List<CfMGateStrategyConfig> getAllCfMGateStrategyConfig() {
        List<CfMGateStrategyConfig> rst = new ArrayList<CfMGateStrategyConfig>();
        Query<CfMGateStrategyConfig> query = this.getSession().createQuery("FROM CfMGateStrategyConfig", CfMGateStrategyConfig.class);
        try {
            rst = query.getResultList();
            return rst;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<CfMGateStrategyConfig>();
        }
    }
}
