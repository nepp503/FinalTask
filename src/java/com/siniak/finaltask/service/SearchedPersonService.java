package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.DaoManager;
import com.siniak.finaltask.dao.SearchedPersonDao;
import com.siniak.finaltask.entity.SearchedPerson;
import com.siniak.finaltask.exception.DaoException;

import java.util.List;

public class SearchedPersonService extends AbstractService {

    public SearchedPerson create(SearchedPerson person) throws DaoException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        return dao.create(person);
    }

    public List<SearchedPerson> findAll() throws DaoException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        return dao.findAll();
    }

    public List<SearchedPerson> findPersonByNamePart(String name) throws DaoException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        return dao.findPersonByNamePart(name);
    }

    public SearchedPerson update(SearchedPerson person) throws DaoException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        return dao.update(person);
    }

    public SearchedPerson findById(int id) throws DaoException {
        SearchedPersonDao dao = manager.getSearchedPersonDao();
        return dao.findEntityById(id);
    }
}
