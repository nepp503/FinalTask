package com.siniak.finaltask.command;

import com.siniak.finaltask.controller.Router;
import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.exception.ServiceException;
import com.siniak.finaltask.service.UserService;
import com.siniak.finaltask.controller.SessionRequestContent;
import org.apache.logging.log4j.Level;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.*;

public class SignUpCommand implements Command{

    public SignUpCommand() {
    }

    @Override
    public Router execute(SessionRequestContent content) {
        Router router = new Router();
        UserService userService = new UserService();
        try {
            User user = userService.registerUser(createUser(content));
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

    private User createUser(SessionRequestContent content){
        User user = new User();
        user.setLogin(content.getParameter(LOGIN_PARAMETR));
        user.setPassword(content.getParameter(PASSWORD_PARAMETR));
        user.setFirstName(content.getParameter(FIRSTNAME_PARAMETR));
        user.setLastName(content.getParameter(LASTNAME_PARAMETR));
        return user;
    }
}
