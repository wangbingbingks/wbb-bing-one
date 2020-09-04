package com.corsface.base.dao;

import com.corsface.base.entity.BeUser;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wbb on 2020/8/13.
 */
@Repository
public class BeUserDao extends AbstractBaseDao {


    @Transactional
    public BeUser getUserByLoginName(String loginName) {
        BeUser beUser = null;
        Query<BeUser> query = this.getSession().createQuery("FROM BeUser WHERE loginName = :loginName", BeUser.class);
        query.setParameter("loginName", loginName);
        try {
            beUser = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return beUser;
    }

    @Transactional
    public BeUser getUserById(int id) {
        BeUser beUser = null;
        Query<BeUser> query = this.getSession().createQuery("FROM BeUser WHERE id = :id", BeUser.class);
        query.setParameter("id", id);
        try {
            beUser = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return beUser;
    }

    @Transactional
    public boolean deleteAll(Long userId) {
        int count = 0;

        Query delUserRoleQuery = this.getSession().createQuery("DELETE BeUserRole WHERE userId=:userId");
        delUserRoleQuery.setParameter("userId", userId);
        count += delUserRoleQuery.executeUpdate();

        Query delUserQuery = this.getSession().createQuery("DELETE BeUser WHERE id=:userId");
        delUserQuery.setParameter("userId", userId);
        count += delUserQuery.executeUpdate();

        return count>0;
    }

    @Transactional
    public long getAllBeUsersTotal(String loginName, String name) {
        long count = 0;

        StringBuffer sql = new StringBuffer("select count(id) from be_user t where 1=1");

        if(loginName != null){
            sql.append(" and login_name like :login_name");
        }
        if(name != null){
            sql.append(" and name like :name");
        }

        Query query = this.getSession().createNativeQuery(sql.toString());

        if(loginName != null){
            query.setParameter("login_name", String.format("%%s%", loginName));
        }
        if(name != null){
            query.setParameter("name", String.format("%%s%", name));
        }

        try {
            count = ((Number) query.getSingleResult()).longValue();
        }catch (Exception e){
            e.printStackTrace();
            count = 0;
        }
        return count;
    }

    @Transactional
    public List<BeUser> getAllBeUsersData(int pageSize, int startIndex, String loginName, String name) {
        List<BeUser> rst = null;
        StringBuffer sql = new StringBuffer("FROM BeUser WHERE 1=1");
        if(loginName != null){
            sql.append(" and loginName like :loginName");
        }
        if(name != null){
            sql.append(" and name like :name");
        }
        sql.append(" order by id asc");
        Query<BeUser> query = this.getSession().createQuery(sql.toString(), BeUser.class);
        if(loginName != null){
            query.setParameter("loginName", loginName);
        }
        if(name != null){
            query.setParameter("name", name);
        }
        //分页
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);

        try {
            rst = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            rst = null;
        }
        return rst;
    }
}
