package com.siniak.finaltask.dao;

import com.siniak.finaltask.connection.ConnectionPool;
import com.siniak.finaltask.exception.ConnectionPoolException;

import java.sql.Connection;

public class DaoManager {
    private ConnectionPool pool = ConnectionPool.getInstance();
    private Connection connection = null;

    public DaoManager() {
        try {
            this.connection = pool.getConnection();
        } catch (ConnectionPoolException e) {
            throw new RuntimeException();
        }
    }
//    public AbstractDao createDao(Entity entity) throws ConnectionPoolException {
//        AbstractDao dao = null;
//        Connection connection = null;
//        if (entity instanceof User) {
//            connection = pool.getConnection();
//            dao = new UserDao(connection);
//        }
//        return dao;
//    }

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
