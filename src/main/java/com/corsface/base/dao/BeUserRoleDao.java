package com.corsface.base.dao;

import com.corsface.base.entity.BeRole;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BeUserRoleDao extends AbstractBaseDao{

    @Transactional
    public boolean getIsInitialization(String token) {
        boolean rst = false;
        String sql = "SELECT t.* from be_role t LEFT join be_user_role ur ON t.id=ur.role_id LEFT JOIN be_user u ON  ur.user_id=u.id " +
                "WHERE u.token=:token AND t.isinitialization=1";
        NativeQuery query = this.getSession().createNativeQuery(sql);
        query.setParameter("token", token);
        try {
            List<?> list = query.getResultList();
            if(list != null && list.size() > 0){
                rst = true;
            }
        }catch (Exception e){
            e.printStackTrace();
            rst = false;
        }
        return rst;
    }

    @Transactional
    public List<BeRole> getRoleByUserId(Long userId) {
        List<BeRole> rst = new ArrayList<>();
        String sql = "select r.* from be_user_role ur left join be_role r on ur.role_id=r.id where ur.user_id=:userId";
        Query<BeRole> query = this.getSession().createNativeQuery(sql, BeRole.class);
        query.setParameter("userId", userId);
        try {
            rst = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rst;
    }
}
