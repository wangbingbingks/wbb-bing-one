package com.product.sc.dao;

import com.product.sc.entity.CfPoi;
import com.product.sc.redis.PoiRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wbb on 2020/8/13.
 */

@SuppressWarnings("unchecked")
@Repository
public class CacheDao {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PoiRedisDao poiRedisDao;

    /**
     * PoiCache
     */
    public CfPoi getPoiByPersonId(String personId) {
        return poiRedisDao.get(personId);
    }

    public boolean savePoiCache(CfPoi cfPoi) {
        return poiRedisDao.save(cfPoi);
    }

    public boolean deletePoiCache(String personId) {
        return poiRedisDao.delete(personId);
    }
}
