package com.siniak.finaltask.dao;

import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.entity.UserType;
import com.siniak.finaltask.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.siniak.finaltask.constant.Constant.*;
import static com.siniak.finaltask.dao.constants.SearchedPersonQuery.UPDATE_SEARCHED_PERSON;
import static com.siniak.finaltask.dao.constants.UserQuery.*;

public class UserDao extends AbstractDao<User> {

    public UserDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                defineUser(resultSet, user);
                users.add(user);
            }
        } catch (SQLException ex) {
            throw new DaoException("SQL failed", ex);
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
            throw new DaoException("SQL request failed", ex);
        } finally {
            closeStatement(statement);
        }
        return user;
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        boolean result = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE_USER);
            statement.setInt(1, id);
            statement.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            throw new DaoException("SQL request failed", ex);
        } finally {
            closeStatement(statement);
        }
        return result;
    }

    @Override
    public User create(User user) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
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
            throw new DaoException(e);
        }
    }

    public User findByLoginAndPassword(String login, String password) throws DaoException {
        User user = new User();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_USER_BY_LOGIN_AND_PASSWORD);
            statement.setString(1, login);
            statement.setString(2, password);
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
        user.setId(resultSet.getInt("iduser"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setFirstName(resultSet.getString("firstname"));
        user.setLastName(resultSet.getString("lastname"));
        user.setUserType(UserType.valueOf(resultSet.getString("role").toUpperCase()));
        return user;
    }
}
