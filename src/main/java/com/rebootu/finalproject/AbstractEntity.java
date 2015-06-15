package com.rebootu.finalproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by tanyacouture on 6/4/15. From Chris Bay's java cs50-finance-java
 */
@MappedSuperclass
public abstract class AbstractEntity {

    private int uid;

    @Id
    @GeneratedValue
    @Column(name = "entryNum", unique = true, nullable = false)
    public int getUid() { return uid; }

    protected void setUid(int uid) { this.uid = uid; }

    public void save() {

        Configuration conf = new Configuration();
        conf.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory factory = conf.buildSessionFactory(serviceRegistry);

        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        session.persist(this);

        t.commit();
        session.close();
    }
}
