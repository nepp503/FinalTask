package test.com.siniak.finaltask.connection;

import com.siniak.finaltask.connection.ConnectionPool;
import com.siniak.finaltask.exception.ConnectionPoolException;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    public void getConnectionTest() throws ConnectionPoolException {
        Connection connection = ConnectionPool.getInstance().getConnection();
    }

    @Test
    public void releaseConnectionTest() throws ConnectionPoolException, SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        connection.close();
    }
}
