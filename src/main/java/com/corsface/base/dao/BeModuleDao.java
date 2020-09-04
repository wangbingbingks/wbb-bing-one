package com.corsface.base.dao;

import com.corsface.base.entity.BeFunction;
import com.corsface.base.entity.BeModule;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by wbb on 2020/8/13.
 */
@Repository
public class BeModuleDao extends AbstractBaseDao {

    @Transactional
    public BeModule getBeModuleById(long moduleId) {
        BeModule rst = null;
        try {
            rst = this.getSession().createQuery("from BeModule t where t.id = :id", BeModule.class).setParameter("id", moduleId).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rst;
    }

    @Transactional
    public BeFunction getDefaultFunction(Long moduleId) {
        BeFunction rst = null;
        try {
            List<BeFunction> list = this.getSession().createQuery("from BeFunction t where t.moduleId = :moduleId and t.isDefault = 1 ", BeFunction.class).setParameter("moduleId", moduleId).getResultList();
            if (list != null && list.size() > 0) {
                rst = (BeFunction) list.get(0);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rst;
    }

    @Transactional
    public List<BeModule> getVisibleBeModulesByParentId(Long parentId, boolean showHide) {
        List<BeModule> rst = null;

        String hql = "from BeModule t where t.parentId = :parentId and t.isDisplay = 1 order by t.sortNum asc";
        if (showHide) {
            hql = "from BeModule t where t.parentId = :parentId  order by t.sortNum asc";
        }
        try {
            rst = this.getSession().createQuery(hql, BeModule.class).setParameter("parentId", parentId).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rst;
    }
}
