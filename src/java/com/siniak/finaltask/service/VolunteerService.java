package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.DaoManager;
import com.siniak.finaltask.dao.VolunteerDao;
import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.DaoException;

import java.util.List;

public class VolunteerService extends AbstractService {

    public Volunteer create(Volunteer volunteer) throws DaoException {
        VolunteerDao dao = manager.getVolunteerDao();
        return dao.create(volunteer);
    }

    public List<Volunteer> findAll() throws DaoException {
        VolunteerDao dao = manager.getVolunteerDao();
        return dao.findAll();
    }

    public Volunteer update(Volunteer volunteer) throws DaoException {
        VolunteerDao dao = manager.getVolunteerDao();
        return dao.update(volunteer);
    }

    public Volunteer findById(int id) throws DaoException {
        VolunteerDao dao = manager.getVolunteerDao();
        return dao.findEntityById(id);
    }
}
