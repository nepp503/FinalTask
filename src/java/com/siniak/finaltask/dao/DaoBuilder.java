package com.siniak.finaltask.dao;

import com.siniak.finaltask.connection.ConnectionPool;
import com.siniak.finaltask.exception.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * Builder for all DAOs in project
 * @author Vitali Siniak
 */

public class DaoBuilder {
    static final Logger logger = LogManager.getLogger();
    private Connection connection;

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

    /**
     * Returns connection back to pool after all operations
     */
    public void finishRequest() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, e);
        }
    }
}
