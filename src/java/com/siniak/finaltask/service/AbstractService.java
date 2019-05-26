package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.DaoBuilder;

public abstract class AbstractService {
    protected DaoBuilder manager = new DaoBuilder();

    public AbstractService() {
    }

    public void finishService() {
        manager.finishRequest();
    }
}
