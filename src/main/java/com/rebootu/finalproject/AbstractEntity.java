package com.rebootu.finalproject;

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

}
