package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.HelpResponseDao;
import com.siniak.finaltask.entity.HelpResponse;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.utils.HelpResponseValidation;

import java.util.List;

import static com.siniak.finaltask.constant.Constant.*;

public class HelpResponseService extends AbstractService{
    HelpResponseValidation validation = new HelpResponseValidation();

    public HelpResponse create(HelpResponse response) throws ServiceException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        HelpResponse userResponse = new HelpResponse();
        try {
            if (validation.isValid(response)) {
                userResponse = dao.create(response);
            }
        } catch (DaoException ex) {
            throw new ServiceException(CREATE_RESPONSE_ERROR_MSG, ex);
        }
        return userResponse;
    }

    public List<HelpResponse> findAll() throws ServiceException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        try {
            return dao.findAll();
        } catch (DaoException ex) {
            throw new ServiceException(FIND_RESPONSE_ERROR_MSG, ex);
        }
    }

    public HelpResponse update(HelpResponse response) throws ServiceException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        HelpResponse userResponse = new HelpResponse();
        try {
            if (validation.isValid(response)) {
                userResponse = dao.update(response);
            }
        } catch (DaoException ex) {
            throw new ServiceException(UPDATE_RESPONSE_ERROR_MSG, ex);
        }
        return userResponse;
    }

    public void deleteById(int id) throws ServiceException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        try {
            dao.deleteById(id);
        } catch (DaoException ex) {
            throw new ServiceException(DELETE_RESPONSE_ERROR_MSG, ex);
        }
    }

    public List<HelpResponse> findByPersonId(int personId) throws ServiceException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        try {
            return dao.findByPersonId(personId);
        } catch (DaoException ex) {
            throw new ServiceException(FIND_RESPONSE_ERROR_MSG, ex);
        }
    }

    public List<HelpResponse> findByUserId(int userId) throws ServiceException {
        HelpResponseDao dao = manager.getHelpResponseDao();
        try {
            return dao.findByUserId(userId);
        } catch (DaoException ex) {
            throw new ServiceException(FIND_RESPONSE_ERROR_MSG, ex);
        }
    }
}
