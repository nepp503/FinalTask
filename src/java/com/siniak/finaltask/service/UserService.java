package com.siniak.finaltask.service;

import com.siniak.finaltask.dao.DaoManager;
import com.siniak.finaltask.dao.UserDao;
import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.DaoException;

public class UserService extends AbstractService {

    public User registerUser(User user) throws DaoException {
        UserDao dao = manager.getUserDao();
        return dao.create(user);
    }

    public User findUserByLoginAndPassword(String login, String password) throws DaoException {
        UserDao dao = manager.getUserDao();
        User currentUser = dao.findByLoginAndPassword(login, password);
        return currentUser;
    }

    public User findUserById(int id) throws DaoException {
        UserDao dao = manager.getUserDao();
        User currentUser = dao.findEntityById(id);
        return currentUser;
    }
}
