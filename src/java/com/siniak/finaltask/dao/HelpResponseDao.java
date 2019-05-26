package com.siniak.finaltask.dao;

import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;
import static com.siniak.finaltask.dao.query.HelpResponseQuery.*;

public class HelpResponseDao extends AbstractDao<HelpResponse> {
    public HelpResponseDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<HelpResponse> findAll() throws DaoException {
        List<HelpResponse> responses = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_ALL_HELP_RESPONSES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                responses.add(defineHelpResponse(resultSet));
            }
        } catch (SQLException ex) {
            throw new DaoException(FIND_RESPONSE_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return responses;
    }

    @Override
    public HelpResponse findEntityById(int id) throws DaoException {
        HelpResponse response = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_HELP_RESPONSE_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                response = defineHelpResponse(resultSet);
            }
        } catch (SQLException ex) {
            throw new DaoException(FIND_RESPONSE_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return response;
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_HELP_RESPONSE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DaoException(DELETE_RESPONSE_ERROR_MSG, e);
        }
    }

    @Override
    public HelpResponse create(HelpResponse response) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_HELP_RESPONSE);
            statement.setInt(1, response.getUserId());
            statement.setInt(2, response.getSearchedPersonId());
            statement.setString(3, response.getTitle());
            statement.setString(4, response.getBody());
            statement.setString(5, response.getUserLogin());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(CREATE_RESPONSE_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return response;
    }

    @Override
    public HelpResponse update(HelpResponse response) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_HELP_RESPONSE);
            statement.setString(1, response.getTitle());
            statement.setString(2, response.getBody());
            statement.setInt(3, response.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(UPDATE_RESPONSE_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return response;
    }

    public List<HelpResponse> findByPersonId(int personId) throws DaoException {
        List<HelpResponse> responses = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_HELP_RESPONSE_BY_PERSON_ID);
            statement.setInt(1, personId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                responses.add(defineHelpResponse(resultSet));
            }
        } catch (SQLException ex) {
            throw new DaoException(FIND_RESPONSE_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return responses;
    }

    public List<HelpResponse> findByUserId(int userId) throws DaoException {
        List<HelpResponse> responses = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_HELP_RESPONSE_BY_USER_ID);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                responses.add(defineHelpResponse(resultSet));
            }
        } catch (SQLException ex) {
            throw new DaoException(FIND_RESPONSE_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return responses;
    }

    private HelpResponse defineHelpResponse(ResultSet resultSet) throws SQLException {
        HelpResponse response = new HelpResponse();
        response.setId(resultSet.getInt(ID_PARAMETR));
        response.setUserId(resultSet.getInt(USER_ID_PARAMETR));
        response.setSearchedPersonId(resultSet.getInt(SP_ID_PARAMETR));
        response.setTitle(resultSet.getString(TITLE_PARAMETR));
        response.setBody(resultSet.getString(BODY_PARAMETR));
        response.setUserLogin(resultSet.getString(USER_LOGIN_PARAMETR));
        return response;
    }
}
