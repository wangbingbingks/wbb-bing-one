package com.corsface.base.dao;

import com.corsface.base.entity.BeRole;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BeRoleDao extends AbstractBaseDao{

    @Transactional
    public List<BeRole> getAllRole() {
        List<BeRole> rst = null;
        String hql = "FROM BeRole";
        Query<BeRole> query = this.getSession().createQuery(hql, BeRole.class);
        rst = query.getResultList();
        return rst;
    }
}
