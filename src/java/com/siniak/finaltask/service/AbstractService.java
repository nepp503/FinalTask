package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.DaoBuilder;

/**
 * Base class for all services
 * @author Vitali Siniak
 */

public abstract class AbstractService {
    protected DaoBuilder manager = new DaoBuilder();

    public AbstractService() {
    }

    /**
     * Wrapper method for
     * @see DaoBuilder#finishRequest()
     */
    public void finishService() {
        manager.finishRequest();
    }
}
