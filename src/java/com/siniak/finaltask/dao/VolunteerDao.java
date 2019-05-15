package com.siniak.finaltask.dao;

import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.siniak.finaltask.constant.Constant.*;
import static com.siniak.finaltask.dao.constants.VolunteerQuery.*;

public class VolunteerDao extends AbstractDao<Volunteer> {
    public VolunteerDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Volunteer> findAll() throws DaoException {
        List<Volunteer> volunteers = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_VOLUNTEERS);
            while (resultSet.next()) {
                volunteers.add(defineVolunteer(resultSet));
            }
        } catch (SQLException ex) {
            throw new DaoException("SQL failed", ex);
        } finally {
            closeStatement(statement);
        }
        return volunteers;
    }

    @Override
    public Volunteer findEntityById(int id) throws DaoException {
        Volunteer volunteer = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_VOLUNTEER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                volunteer = defineVolunteer(resultSet);
            }
        } catch (SQLException ex) {
            throw new DaoException("SQL request failed", ex);
        } finally {
            closeStatement(statement);
        }
        return volunteer;
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_VOLUNTEER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Volunteer create(Volunteer volunteer) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_VOLUNTEER);
            statement.setString(1, volunteer.getFirstName());
            statement.setString(2, volunteer.getLastName());
            statement.setString(3, volunteer.getPhoto());
            statement.setInt(4, volunteer.getYearsOfWork());
            statement.setInt(5, volunteer.getNumberOfOperations());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(CREATE_USER_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return volunteer;
    }

    @Override
    public Volunteer update(Volunteer volunteer) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_VOLUNTEER);
            statement.setString(1, volunteer.getFirstName());
            statement.setString(2, volunteer.getLastName());
            statement.setString(3, volunteer.getPhoto());
            statement.setInt(4, volunteer.getYearsOfWork());
            statement.setInt(5, volunteer.getNumberOfOperations());
            statement.setInt(6, volunteer.getId());
            statement.executeUpdate();
            return volunteer;
        } catch (SQLException e) {
            System.out.println(e);
            throw new DaoException(e);
        }
    }

    private Volunteer defineVolunteer(ResultSet resultSet) throws SQLException {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(resultSet.getInt(ID_PARAMETR));
        volunteer.setFirstName(resultSet.getString(FIRSTNAME_PARAMETR));
        volunteer.setLastName(resultSet.getString(LASTNAME_PARAMETR));
        volunteer.setPhoto(resultSet.getString(PHOTO_PARAMETR));
        volunteer.setYearsOfWork(resultSet.getInt(YEARS_OF_WORK_PARAMETR));
        volunteer.setNumberOfOperations(resultSet.getInt(NUMBER_OF_OPERATIONS_PARAMETR));
        return volunteer;
    }
}
