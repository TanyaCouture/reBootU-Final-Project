package com.rebootu.finalproject.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by tanyacouture on 6/15/15.
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport{

    @Autowired
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
}
