package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.SearchedPersonDao;
import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.exception.ServiceException;

import java.util.List;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.*;

/**
 * Service for searched people
 * @author Vitali Siniak
 */

public class SearchedPersonService extends AbstractService {

    public SearchedPerson create(SearchedPerson person) throws ServiceException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        try {
            return dao.create(person);
        } catch (DaoException ex) {
            throw new ServiceException(CREATE_PERSON_ERROR_MSG, ex);
        }
    }

    public List<SearchedPerson> findAll() throws ServiceException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        try {
            return dao.findAll();
        } catch (DaoException ex) {
            throw new ServiceException(FIND_PERSON_ERROR_MSG, ex);
        }
    }

    public List<SearchedPerson> findPersonByNamePart(String name) throws ServiceException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        try {
            return dao.findPersonByNamePart(name);
        } catch (DaoException ex) {
            throw new ServiceException(FIND_PERSON_ERROR_MSG, ex);
        }
    }

    public SearchedPerson update(SearchedPerson person) throws ServiceException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        try {
            return dao.update(person);
        } catch (DaoException ex) {
            System.out.println(ex);
            throw new ServiceException(UPDATE_PERSON_ERROR_MSG, ex);
        }
    }

    public SearchedPerson findById(int id) throws ServiceException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        try {
            return dao.findEntityById(id);
        } catch (DaoException ex) {
            throw new ServiceException(FIND_PERSON_ERROR_MSG, ex);
        }
    }

    public boolean deleteById(int id) {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        return dao.deleteById(id);
    }
}
