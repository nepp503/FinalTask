package com.siniak.finaltask.dao;

import com.siniak.finaltask.connection.ConnectionPool;
import com.siniak.finaltask.exception.ConnectionPoolException;

import java.sql.Connection;

public class DaoBuilder {
    private Connection connection ;

    public DaoBuilder() {
        try {
            this.connection = ConnectionPool.getInstance().getConnection();
        } catch (ConnectionPoolException e) {
            throw new RuntimeException();
        }
    }

    public UserDao getUserDao() {
        UserDao dao = new UserDao(connection);
        return dao;
    }

    public SearchedPersonDao getSearchedPersonDao() {
        SearchedPersonDao dao = new SearchedPersonDao(connection);
        return dao;
    }

    public VolunteerDao getVolunteerDao() {
        VolunteerDao dao = new VolunteerDao(connection);
        return dao;
    }

    public HelpResponseDao getHelpResponseDao() {
        HelpResponseDao dao = new HelpResponseDao(connection);
        return dao;
    }
}
