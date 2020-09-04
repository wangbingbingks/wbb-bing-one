package com.corsface.base.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by wbb on 2020/8/13.
 */
public abstract class AbstractBaseDao {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected SessionFactory sessionFactory;


    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Transactional
    public boolean save(Object entity) {
        boolean rst = false;
        try {
            getSession().saveOrUpdate(entity);
            rst = true;
        } catch (Exception e) {
            e.printStackTrace();
            rst = false;
        }

        return rst;
    }

    @Transactional
    public boolean delete(Object entity) {
        boolean rst = false;
        try {
            getSession().delete(entity);
            rst = true;
        } catch (Exception e) {
            e.printStackTrace();
            rst = false;
        }

        return rst;
    }
}
