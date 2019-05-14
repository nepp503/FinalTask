package com.siniak.finaltask.dao;
import com.siniak.finaltask.entity.Entity;
import com.siniak.finaltask.exception.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao<E extends Entity> {
    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract List<E> findAll() throws DaoException;

    public abstract E findEntityById(int id) throws DaoException;

    public abstract boolean deleteById(int id) throws DaoException;

    public abstract Entity create(E entity) throws DaoException;

    public abstract E update(E entity) throws DaoException;

    public void closeStatement(Statement statement) throws DaoException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            throw new DaoException("Statement exception", ex);
        }
    }
}
