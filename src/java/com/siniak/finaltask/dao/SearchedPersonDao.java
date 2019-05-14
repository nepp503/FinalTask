package com.siniak.finaltask.dao;

import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.siniak.finaltask.constant.Constant.*;
import static com.siniak.finaltask.dao.constants.SearchedPersonQuery.*;

public class SearchedPersonDao extends AbstractDao<SearchedPerson> {

    public SearchedPersonDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<SearchedPerson> findAll() throws DaoException {
        List<SearchedPerson> people = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_SERCHED_PERSON);
            while (resultSet.next()) {
                people.add(defineSearchedPerson(resultSet));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new DaoException("SQL failed", ex);
        } finally {
            closeStatement(statement);
        }
        return people;
    }

    @Override
    public SearchedPerson findEntityById(int id) throws DaoException {
        SearchedPerson person = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_SEARCHED_PERSON_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                person = defineSearchedPerson(resultSet);
            }
        } catch (SQLException ex) {
            throw new DaoException("SQL request failed", ex);
        } finally {
            closeStatement(statement);
        }
        return person;
    }

    @Override
    public boolean deleteById(int id) throws DaoException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_SEARCHED_PERSON_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public SearchedPerson create(SearchedPerson searchedPerson) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_SEARCHED_PERSON);
            statement.setInt(1, searchedPerson.getId());
            statement.setString(2, searchedPerson.getFirstName());
            statement.setString(3, searchedPerson.getLastName());
            statement.setString(4, searchedPerson.getBirthPlace());
            statement.setString(5, searchedPerson.getSearchArea());
            statement.setString(6, searchedPerson.getSpecialSigns());
            statement.setString(7, searchedPerson.getPhoto());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException(CREATE_USER_ERROR_MSG, ex);
        } finally {
            closeStatement(statement);
        }
        return searchedPerson;
    }

    @Override
    public SearchedPerson update(SearchedPerson person) throws DaoException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_SEARCHED_PERSON);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getBirthPlace());
            preparedStatement.setString(4, person.getSearchArea());
            preparedStatement.setString(5, person.getSpecialSigns());
            preparedStatement.setString(6, person.getPhoto());
            preparedStatement.setInt(7, person.getId());
            preparedStatement.executeUpdate();
            return person;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<SearchedPerson> findPersonByNamePart(String name) throws DaoException {
        List<SearchedPerson> people = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(FIND_PERSON_BY_LASTNAME);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                people.add(defineSearchedPerson(resultSet));
            }
        } catch (SQLException ex) {
            throw new DaoException("SQL request failed", ex);
        } finally {
            closeStatement(statement);
        }
        return people;
    }

    private SearchedPerson defineSearchedPerson(ResultSet resultSet) throws SQLException {
        SearchedPerson person = new SearchedPerson();
        person.setId(resultSet.getInt(ID_PARAMETR));
        person.setFirstName(resultSet.getString(FIRSTNAME_PARAMETR));
        person.setLastName(resultSet.getString(LASTNAME_PARAMETR));
        person.setBirthPlace(resultSet.getString(BIRTH_PLACE_PARAMETR));
        person.setSearchArea(resultSet.getString(SEARCH_AREA_PARAMETR));
        person.setSpecialSigns(resultSet.getString(SPECIAl_SIGNS_PARAMETR));
        person.setPhoto(resultSet.getString(PHOTO_PARAMETR));
        return person;
    }
}
