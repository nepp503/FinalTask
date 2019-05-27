package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.UserDao;
import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.util.UserValidation;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.*;

/**
 * Service for users
 * @author Vitali Siniak
 */

public class UserService extends AbstractService {
    private static UserValidation validation = new UserValidation();

    public User registerUser(User user) throws ServiceException {
        UserDao dao = manager.getUserDao();
        User currentUser = new User();
        try {
            if (validation.isValid(user)) {
                currentUser = dao.create(user);
            }
        } catch (DaoException ex) {
            throw new ServiceException(CREATE_USER_ERROR_MSG, ex);
        }
        return currentUser;
    }

    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {
        UserDao dao = manager.getUserDao();
        try {
            User currentUser = dao.findByLoginAndPassword(login, password);
            return currentUser;
        } catch (DaoException ex) {
            throw new ServiceException(FIND_USER_ERROR_MSG, ex);
        }
    }

    public User findUserById(int id) throws ServiceException {
        UserDao dao = manager.getUserDao();
        try {
            User currentUser = dao.findEntityById(id);
            return currentUser;
        }catch (DaoException ex) {
            throw new ServiceException(FIND_USER_ERROR_MSG, ex);
        }
    }

    public User update(User user) throws ServiceException {
        UserDao dao = manager.getUserDao();
        User currentUser = new User();
        try {
            if (validation.isUpdateValid(user)) {
                currentUser = dao.update(user);
            }
        } catch (DaoException ex) {
            throw new ServiceException(UPDATE_USER_ERROR_MSG, ex);
        }
        return currentUser;
    }
}
