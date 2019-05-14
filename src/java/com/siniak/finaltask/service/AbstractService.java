package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.DaoManager;

public abstract class AbstractService {
    protected DaoManager manager = new DaoManager();

    public AbstractService() {
    }
}
