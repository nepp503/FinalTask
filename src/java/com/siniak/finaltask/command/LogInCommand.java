package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.UserService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;

public class LogInCommand implements Command {

    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        UserService userService = new UserService();
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
        }finally {
            userService.finishService();
        }
        return router;
    }
}
