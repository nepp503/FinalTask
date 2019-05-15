package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.DaoManager;
import com.siniak.finaltask.dao.HelpResponseDao;
import com.siniak.finaltask.dao.VolunteerDao;
import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.DaoException;

import java.util.List;

public class HelpResponseService extends AbstractService{

    public HelpResponse create(HelpResponse response) throws DaoException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        return dao.create(response);
    }

    public List<HelpResponse> findAll() throws DaoException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        return dao.findAll();
    }

    public HelpResponse update(HelpResponse response) throws DaoException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        return dao.update(response);
    }

    public void deleteById(int id) throws DaoException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        dao.deleteById(id);
    }

    public List<HelpResponse> findByPersonId(int personId) throws DaoException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        return dao.findByPersonId(personId);
    }

    public List<HelpResponse> findByUserId(int userId) throws DaoException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        return dao.findByUserId(userId);
    }
}
