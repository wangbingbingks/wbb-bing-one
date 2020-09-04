package com.product.sc.redis;

import com.product.sc.entity.CfPoi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wbb on 2020/8/13.
 */

@Repository
public class PoiRedisDao {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("redisTemplate_cfPoi")
    private RedisTemplate<String, CfPoi> template;

    @Resource(name = "redisTemplate_cfPoi")
    private ValueOperations<String, CfPoi> valueOp;

    public static String getKeyForPoi(String pid) {
        return "cf_poi_pid:" + pid;
    }

    public boolean save(CfPoi cfPoi) {
        boolean rst = false;
        if (cfPoi == null) {
            return false;
        }

        String pid = cfPoi.getPersonId();
        try {
            valueOp.set(getKeyForPoi(pid), cfPoi);
            rst = true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->PoiRedisDao, save, error, pid:{}, error:{}", pid, e.getMessage());
        }

        return rst;
    }

    public boolean delete(String pid) {
        String key = getKeyForPoi(pid);
        template.delete(key);
        return true;
    }

    public CfPoi get(String pid) {
        String key = getKeyForPoi(pid);
        return valueOp.get(key);
    }

    public RedisTemplate<String, CfPoi> getTemplate() {
        return template;
    }

    public void setTemplate(RedisTemplate<String, CfPoi> template) {
        this.template = template;
    }
}
