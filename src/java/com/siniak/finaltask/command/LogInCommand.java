package com.siniak.finaltask.command;

import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.DaoException;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.UserService;
import com.siniak.finaltask.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.constant.Constant.*;

public class LogInCommand implements Command {
    private UserService userService = new UserService();

    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        try {
            String login = content.getParameter(LOGIN_PARAMETR);
            String password = content.getParameter(PASSWORD_PARAMETR);
            User user = userService.findUserByLoginAndPassword(login, password);
            content.setSessionAttribute(USER_ATTR, user);
            router.setRedirect();
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
            content.setRequestAttribute(ERROR_MESSAGE_ATTR, e);
            router.setPage(ERROR_PAGE);
        }
        return router;
    }
}
