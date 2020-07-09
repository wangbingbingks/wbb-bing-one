package com.corsface.base.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBaseDao {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected SessionFactory sessionFactory;
}
