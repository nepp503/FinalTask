package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.VolunteerDao;
import com.siniak.finaltask.entity.Volunteer;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.exception.ServiceException;

import java.util.List;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;

public class VolunteerService extends AbstractService {

    public Volunteer create(Volunteer volunteer) throws ServiceException {
        VolunteerDao dao = manager.getVolunteerDao();
        try{
            return dao.create(volunteer);
        } catch (DaoException ex) {
            throw new ServiceException(CREATE_VOLUNTEER_ERROR_MSG, ex);
        }
    }

    public List<Volunteer> findAll() throws ServiceException {
        VolunteerDao dao = manager.getVolunteerDao();
        try {
            return dao.findAll();
        } catch (DaoException ex) {
            throw new ServiceException(FIND_VOLUNTEER_ERROR_MSG, ex);
        }
    }

    public Volunteer update(Volunteer volunteer) throws ServiceException {
        VolunteerDao dao = manager.getVolunteerDao();
        try {
            return dao.update(volunteer);
        } catch (DaoException ex) {
            throw new ServiceException(UPDATE_VOLUNTEER_ERROR_MSG, ex);
        }
    }

    public Volunteer findById(int id) throws ServiceException {
        VolunteerDao dao = manager.getVolunteerDao();
        try {
            return dao.findEntityById(id);
        } catch (DaoException ex) {
            throw new ServiceException(FIND_VOLUNTEER_ERROR_MSG, ex);
        }
    }

    public boolean deleteById(int id) throws ServiceException {
        VolunteerDao dao = manager.getVolunteerDao();
        try {
            return dao.deleteById(id);
        } catch (DaoException ex) {
            throw new ServiceException(DELETE_VOLUNTEER_ERROR_MSG, ex);
        }
    }
}
