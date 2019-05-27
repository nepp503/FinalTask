package com.siniak.finaltask.dao;
import com.siniak.finaltask.entity.Entity;
import com.siniak.finaltask.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Base class for project DataAccessObjects
 * Implements DAO pattern
 * @author Vitali Siniak
 */

public abstract class AbstractDao<E extends Entity> {
    protected Connection connection;
    static final Logger logger = LogManager.getLogger();

    /**
     * Constructor with parameter
     * @param connection
     * @see Connection
     */
    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * Finds all entities in database
     * @return list of all entities from database
     * @see List
     * @see Entity
     * @throws DaoException
     */
    public abstract List<E> findAll() throws DaoException;

    /**
     * Finds entity in database by its id
     * @param id - entity id
     * @return
     * @see Entity
     * @throws DaoException
     */
    public abstract E findEntityById(int id) throws DaoException;

    /**
     * Deletes entity from database by its id
     * @param id - entity id
     * @return true, if deleting is successful, false otherwise
     * @throws DaoException
     */
    public abstract boolean deleteById(int id) ;

    /**
     * Creates entity and adds it to database
     * @param entity - entity to add to database
     * @return added entity
     * @throws DaoException
     */
    public abstract E create(E entity) throws DaoException;

    /**
     * Updates entity in database
     * @param entity - entity to update
     * @return updated entity
     * @throws DaoException
     */
    public abstract E update(E entity) throws DaoException;

    /**
     * Closes statement
     * @param statement
     * @see Statement
     */
    public void closeStatement(Statement statement){
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
           logger.log(Level.WARN, ex);
        }
    }
}
