package com.product.sc.dao;

import com.corsface.base.dao.AbstractBaseDao;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by wbb on 2020/8/13.
 */

@Repository
public class MKeyDetailsDao extends AbstractBaseDao {

    @Transactional
    public List<String> getAllMKeyDetails() {
        List<String> rst = new ArrayList<String>();
        NativeQuery query = this.getSession().createNativeQuery("SELECT t.code FROM key_code t");
        try {
            rst = query.getResultList();
            return rst;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<String>();
        }

    }

    @Transactional
    public int saveMKeyDetails(Set<String> activationCode, Date now) {
        Iterator<String> set = activationCode.iterator();
        int addCount = 0;
        while (set.hasNext()) {
            int exeOk = 0;
            NativeQuery query = this.getSession().createNativeQuery("INSERT INTO key_code (code,gmt_create,gmt_modify) values (:activationCode,:createTime,:modifyTime)");
            query.setParameter("activationCode", set.next());
            query.setParameter("createTime", now);
            query.setParameter("modifyTime", now);
            exeOk = query.executeUpdate();
            if (exeOk > 0) {
                addCount++;
            }
        }
        return addCount;

    }

}
