package com.siniak.finaltask.dao;

import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.entity.UserType;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.util.PasswordEncoder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.*;
import static com.siniak.finaltask.dao.query.UserQuery.*;

/**
 * DAO for users
 * @author Vitali Siniak
 */
public class UserDao extends AbstractDao<User> {

    public UserDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_ALL_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                defineUser(resultSet, user);
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new DaoException(FIND_USER_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return users;
    }

    @Override
    public User findEntityById(int id) throws DaoException {
        User user = new User();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_USER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                defineUser(resultSet, user);
            }
        } catch (SQLException ex) {
            throw new DaoException(FIND_USER_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return user;
    }

    @Override
    public boolean deleteById(int id) {
        boolean result = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE_USER);
            statement.setInt(1, id);
            statement.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            return false;
        } finally {
            closeStatement(statement);
        }
        return result;
    }

    @Override
    public User create(User user) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getLogin());
            statement.setString(2, PasswordEncoder.encodePassword(user.getPassword(), user.getLogin()));
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                user.setId(generatedKey.getInt(1));
            }
        } catch (SQLException ex) {
            throw new DaoException(CREATE_USER_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return user;
    }

    @Override
    public User update(User user) throws DaoException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new DaoException(UPDATE_USER_ERROR_MSG, e);
        }
    }

    /**
     * Finds user with login and password
     * @param login - user login
     * @param password - user password
     * @return user with these login and password
     * @throws DaoException
     */
    public User findByLoginAndPassword(String login, String password) throws DaoException {
        User user = new User();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_USER_BY_LOGIN_AND_PASSWORD);
            statement.setString(1, login);
            statement.setString(2, PasswordEncoder.encodePassword(password, login));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                defineUser(resultSet, user);
            }
        } catch (SQLException ex) {
            throw new DaoException(FIND_USER_ERROR_MSG, ex);
        }
        return user;
    }

    private User defineUser(ResultSet resultSet, User user) throws SQLException {
        user.setId(resultSet.getInt(ID_USER_PARAMETR));
        user.setLogin(resultSet.getString(LOGIN_PARAMETR));
        user.setPassword(resultSet.getString(PASSWORD_PARAMETR));
        user.setEmail(resultSet.getString(EMAIL_PARAMETR));
        user.setFirstName(resultSet.getString(FIRSTNAME_PARAMETR));
        user.setLastName(resultSet.getString(LASTNAME_PARAMETR));
        user.setUserType(UserType.valueOf(resultSet.getString(ROLE_PARAMETR).toUpperCase()));
        return user;
    }
}
