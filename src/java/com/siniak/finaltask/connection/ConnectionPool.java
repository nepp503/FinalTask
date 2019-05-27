package com.siniak.finaltask.connection;

import com.siniak.finaltask.exception.ConnectionPoolException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.DATABASE_PATH;

/**
 * Class provides access to connections to database.
 * Implements Singleton pattern.
 * @author Vitali Siniak
 */

public class ConnectionPool {
    private static ConnectionPool instance;
    private String url;
    private String user;
    private String password;
    private int initialPoolSize;
    private int maxPoolSize;
    private LinkedBlockingQueue<ProxyConnection> availableConnection;
    private List<ProxyConnection> usedConnections;

    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static Lock singletonLock = new ReentrantLock();

    static final Logger logger = LogManager.getLogger();

    private ConnectionPool(){
    }

    /**
     * Provides access to the only instance of the class.
     * @return
     * @see ConnectionPool
     */
    public static ConnectionPool getInstance(){
        if(!instanceCreated.get()){
            singletonLock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool();
                    instance.init();
                    instanceCreated.set(true);
                }
            } catch (ConnectionPoolException e) {
                logger.log(Level.FATAL, e);
                throw new RuntimeException("Can't initialize connection pool", e); // todo log
            } finally {
                singletonLock.unlock();
            }
        }
        return instance;
    }

    /**
     * Returns connection from the pool.
     * @return
     * @see ProxyConnection
     * @throws ConnectionPoolException is thrown if there is an error in creation connection.
     */
    public ProxyConnection getConnection() throws ConnectionPoolException {
        ProxyConnection connection = null;
        try {
            if (availableConnection.isEmpty()) {
                if (usedConnections.size() < maxPoolSize) {
                    availableConnection.put(createConnection());
                }
            }
            connection = availableConnection.take();
            usedConnections.add(connection);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    /**
     * Putting connection back into pool.
     * @param connection
     * @see ProxyConnection
     * @return true, if returning connection back to pool is successful,
     * false - if returning connection back to pool failed
     */
    public boolean releaseConnection(ProxyConnection connection){
        boolean isReturned = false;
        try {
            if (!connection.getAutoCommit()) {
                connection.setAutoCommit(true);
            }
            availableConnection.put(connection);
            isReturned = usedConnections.remove(connection);
        } catch (SQLException ex) {
            return false;
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return isReturned;
    }

    /**
     * Destroys the pool
     */
    public void shutdownPool(){
        try {
            for (ProxyConnection c : usedConnections) {
                c.close();
            }
            for (ProxyConnection c : availableConnection) {
                c.reallyClose();
            }
        } catch (SQLException ex) {
            logger.log(Level.ERROR, ex);
        }
        availableConnection.clear();
    }

    private ProxyConnection createConnection() throws ConnectionPoolException {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            throw new ConnectionPoolException("Getting connection problem", ex);
        }
        return new ProxyConnection(connection);
    }

    private void init() throws ConnectionPoolException {
        availableConnection = new LinkedBlockingQueue<>();
        usedConnections = new ArrayList<>();
        ResourceBundle bundle = ResourceBundle.getBundle(DATABASE_PATH);
        try {
            url = bundle.getString("url");
            user = bundle.getString("user");
            password = bundle.getString("password");
            initialPoolSize = Integer.parseInt(bundle.getString("initialPoolSize"));
            maxPoolSize = Integer.parseInt(bundle.getString("maxPoolSize"));
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            for (int i = 0; i<initialPoolSize; i++) {
                availableConnection.put(createConnection());
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } catch (SQLException e) {
            throw new ConnectionPoolException("Exception in database", e);
        }
    }
}
